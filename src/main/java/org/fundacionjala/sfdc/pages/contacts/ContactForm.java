package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class represent Contact Form.
 */
public class ContactForm extends AbstractBasePage {

    @FindBy(id = "name_salutationcon2")
    @CacheLookup
    private WebElement firstNameCategoryField;

    @FindBy(id = "name_firstcon2")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(id = "name_lastcon2")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(id = "con4")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(id = "con5")
    @CacheLookup
    private WebElement titleField;

    @FindBy(id = "con6")
    @CacheLookup
    private WebElement departmentField;

    @FindBy(id = "con7")
    @CacheLookup
    private WebElement birthDateField;

    @FindBy(id = "con8")
    @CacheLookup
    private WebElement reportToField;

    @FindBy(id = "con9")
    @CacheLookup
    private WebElement leadSourceField;

    @FindBy(id = "con10")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(xpath = "//input[@tabindex='31']")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(xpath = "//input[@tabindex='32']")
    @CacheLookup
    private WebElement saveNewBtn;

    @FindBy(xpath = "//input[@tabindex='33']")
    @CacheLookup
    private WebElement cancelBtn;

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm selectFirstNameCategory(final String item) {
        CommonActions.selectItem(firstNameCategoryField, item);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setContactNameField(final String text) {
        CommonActions.sendKeys(firstNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setLastName(final String text) {
        CommonActions.sendKeys(lastNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setAccountName(final String text) {
        CommonActions.sendKeys(accountNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setTitle(final String text) {
        CommonActions.sendKeys(titleField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setDepartment(final String text) {
        CommonActions.sendKeys(departmentField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param date a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm setBirthDate(final String date) {
        CommonActions.sendKeys(birthDateField, date);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return a Contact Form page object.
     */
    public ContactForm selectLeadSource(final String item) {
        CommonActions.selectItem(leadSourceField, item);
        return this;
    }

    /**
     * This method makes click save button.
     *
     * @return a Contact Detail page object.
     */
    public ContactsDetail clickSaveButton() {
        CommonActions.clickElement(saveBtn);
        return new ContactsDetail();
    }

    /**
     * Method that to permit set values to create a new Contact Home.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the opportunity create.
     */
    public Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap();

        strategyMap.put("firstNameCategory", () -> selectFirstNameCategory(String.valueOf(values.get("firstNameCategory"))));
        strategyMap.put("contactName", () -> setContactNameField(String.valueOf(values.get("contactName"))));
        strategyMap.put("lastName", () -> setLastName(String.valueOf(values.get("lastName"))));
        strategyMap.put("title", () -> setTitle(String.valueOf(values.get("title"))));
        strategyMap.put("department", () -> setDepartment(String.valueOf(values.get("department"))));

        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate
     */
    public void fillTheForm(Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
