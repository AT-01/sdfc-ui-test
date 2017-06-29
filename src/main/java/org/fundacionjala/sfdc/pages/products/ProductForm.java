package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.fundacionjala.sfdc.pages.products.ProductFields.NAME;
import static org.fundacionjala.sfdc.pages.products.ProductFields.DESCRIPTION;
import static org.fundacionjala.sfdc.pages.products.ProductFields.CODE;
import static org.fundacionjala.sfdc.pages.products.ProductFields.ACTIVE;
import static org.fundacionjala.sfdc.pages.products.ProductFields.FAMILY;

/**
 * This class handle the product form.
 */
public class ProductForm extends FormBase {

    @FindBy(xpath = "//span[text()='Product Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement productNameTextField;

    @FindBy(xpath = "//span[text()='Product Code']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement productCodeTextField;

    @FindBy(xpath = "//span[text()='Active']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement isActiveCheckBox;

    // product family
    @FindBy(css = "[aria-label=\"Product Family\"]")
    @CacheLookup
    private WebElement productFamilyLabel;

    @FindBy(css = "[title=\"None\"]")
    @CacheLookup
    private WebElement productFamilySelect;

    @FindBy(xpath = "//span[text()='Product Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionTextArea;

    private ProductBuilder productBuilder;

    private Map<String, String> valuesMap;

    /**
     * Constructor that call the parent constructor.
     */
    public ProductForm() {
        super();
    }

    /**
     * Private constructor.
     *
     * @param productBuilder CampaignBuilder class.
     */
    private ProductForm(final ProductBuilder productBuilder) {
        valuesMap = new HashMap<>();
        this.productBuilder = productBuilder;
    }

    /**
     * This method save a new product on "ProductFields" form.
     *
     * @return {@link ProductDetail}
     */
    public ProductDetail saveProduct() {
        valuesMap = productBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "product" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * This method set the product name in the text field.
     *
     * @param productName String with the product name.
     * @return Return this class.
     */
    public ProductForm setProductName(final String productName) {
        CommonActions.sendKeys(productNameTextField, productName);
        return this;
    }

    /**
     * This method checked element.
     *
     * @param flag Boolean with flag.
     * @return {@link ProductForm}.
     */
    public ProductForm checkActiveFlag(final boolean flag) {
        if (!CommonActions.isSelected(isActiveCheckBox) && flag) {
            CommonActions.clickElement(isActiveCheckBox);
        }
        return this;
    }

    /**
     * This method set the product code in the text field.
     *
     * @param productCode String with the product code.
     * @return Return this class.
     */
    public ProductForm setProductCode(final String productCode) {
        CommonActions.sendKeys(productCodeTextField, productCode);
        return this;
    }

    /**
     * This method chose product family.
     *
     * @param productFamily String with the product family.
     * @return Return this class.
     */
    public ProductForm chooseProductFamilyDdl(final String productFamily) {
        wait.until(ExpectedConditions.elementToBeClickable(productFamilyLabel));
        CommonActions.clickElement(productFamilyLabel);
        if (!productFamily.isEmpty()) {
            String cssSelector = "[title=" + productFamily + "]";
            CommonActions.clickElement(driver.findElement(By.cssSelector(cssSelector)));
        }
        return this;
    }

    /**
     * This method chose product description.
     *
     * @param description String with the description.
     * @return Return this class.
     */
    public ProductForm setDescription(final String description) {
        CommonActions.sendKeys(descriptionTextArea, description);
        return this;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ProductDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ProductDetail();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public AbstractBasePage clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ProductDetail();
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
            .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }

    /**
     * Method that to permit set values to create a new OpportunityHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();
        strategyMap.put(NAME.toString(), () -> setProductName(values.get(NAME.toString())));
        strategyMap.put(CODE.toString(), () -> setProductCode(values.get(CODE.toString())));
        strategyMap.put(ACTIVE.toString(), () -> checkActiveFlag(Boolean.parseBoolean(values.get(ACTIVE.toString()))));
        strategyMap.put(FAMILY.toString(), () -> chooseProductFamilyDdl(values.get(FAMILY.toString())));
        strategyMap.put(DESCRIPTION.toString(), () -> setDescription(values.get(DESCRIPTION.toString())));

        return strategyMap;
    }

    /**
     * This class handle the builder pattern.
     */
    public static class ProductBuilder {

        private Map<String, String> strategyMap;

        /**
         * This method build the Product form.
         *
         * @return {@link ProductForm}.
         */
        public ProductForm build() {
            return new ProductForm(this);
        }

        /**
         * Constructor the CampaignBuilder class.
         *
         * @param name Name required by the class.
         */
        public ProductBuilder(final String name) {
            strategyMap = new HashMap<>();
            strategyMap.put(NAME.toString(), name);
        }

        /**
         * This method set the code product.
         *
         * @param code String with code.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setCode(final String code) {
            strategyMap.put(CODE.toString(), code);
            return this;
        }

        /**
         * This method set the description product.
         *
         * @param description String with description.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setDescription(final String description) {
            strategyMap.put(DESCRIPTION.toString(), description);
            return this;
        }

        /**
         * This method set the active product.
         *
         * @param active Boolean with active.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setActive(final Boolean active) {
            strategyMap.put(ACTIVE.toString(), String.valueOf(active));
            return this;
        }

        /**
         * This method set the family product.
         *
         * @param family String with family.
         * @return {@link ProductBuilder}
         */
        public ProductBuilder setFamily(final String family) {
            strategyMap.put(FAMILY.toString(), family);
            return this;
        }

        /**
         * This method set the strategyMap product.
         *
         * @return A map with values set on "product" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
