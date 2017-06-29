package org.fundacionjala.sfdc.pages.products;

import java.util.HashMap;
import java.util.Map;
import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.products.ProductFields.*;

/**
 * This class handle the product details.
 */
public class ProductDetail extends DetailBase {

    private static final String alt = "alt";

    // product name
    @FindBy(xpath = "//span[text()='Product Name']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement productNameLabel;

    // product code
    @FindBy(xpath = "//span[text()='Product Code']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement productCodeLabel;

    // product description
    @FindBy(xpath = "//span[text()='Product Description']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement productDescriptionLabel;

    // active flag
    @FindBy(xpath = "//span[text()='Active']/parent::div/following-sibling::div/span/span/img")
    @CacheLookup
    private WebElement activeFlagImg;

    // active flag
    @FindBy(xpath = "//span[text()='Active']/parent::div/following-sibling::div/span/span/img/@alt")
    @CacheLookup
    private WebElement activeFlagImg2;

    // product family
    @FindBy(css = ".select")
    @CacheLookup
    private WebElement productFamilyLabel;

    @FindBy(css = "a[title=\"None\"]")
    @CacheLookup
    private WebElement productFamilyNoneOption;

    @FindBy(xpath = "//span[@class=\"slds-icon_container slds-icon-utility-down slds-button__icon forceIcon\"]/child::span[1]")
    @CacheLookup
    private WebElement downArrow;

    @FindBy(css = "a[title=\"Delete\"]")
    @CacheLookup
    private WebElement deleteOption;

    @FindBy(css = "a[title=\"Edit\"]")
    @CacheLookup
    private WebElement editOption;

    @FindBy(css = "[class='slds-button slds-button--neutral uiButton--default uiButton--brand uiButton forceActionButton'] span")
    @CacheLookup
    private WebElement confirmDelete;


    /**
     * {@inheritDoc}
     */
    @Override
    public ProductHome clickDeleteButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(deleteOption);
        CommonActions.clickElement(confirmDelete);
        return new ProductHome();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProductForm clickEditButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(editOption);
        return new ProductForm();
    }

    /**
     * Method that permit gets texts.
     *
     * @return a Map with the values of product edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();
        strategyMap.put(NAME.toString(), this::getProductName);
        strategyMap.put(CODE.toString(), this::getProductCode);
        strategyMap.put(ACTIVE.toString(), () -> String.valueOf(isActiveFlag()));
        //strategyMap.put(FAMILY.toString(), this::getProductFamily);
        strategyMap.put(DESCRIPTION.toString(), this::getDescription);
        return strategyMap;
    }

    /**
     * This method verify that product is displayed.
     *
     * @param product String with product.
     * @return returns <product>true<product/> if product is displayed.
     */
    public boolean isProductDisplayed(final String product) {
        return CommonActions.existElementByLinkText(product);
    }

    /**
     * This method verify that flag is active.
     *
     * @return Return true if is active.
     */
    public boolean isActiveFlag() {
        return Boolean.valueOf(activeFlagImg.getAttribute(alt));
    }

    /**
     * This method obtains the product family.
     *
     * @return String with product family.
     */
    public String getProductFamily() {
        CommonActions.clickElement(productFamilyLabel);
        CommonActions.clickElement(productFamilyNoneOption);
        return "";
    }

    /**
     * This method obtains the product name.
     *
     * @return String with product name.
     */
    public String getProductName() {
        return CommonActions.getText(productNameLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getProductCode() {
        return CommonActions.getText(productCodeLabel);
    }

    /**
     * This method obtains the product code.
     *
     * @return String with product code.
     */
    public String getDescription() {
        return CommonActions.getText(productDescriptionLabel);
    }

}
