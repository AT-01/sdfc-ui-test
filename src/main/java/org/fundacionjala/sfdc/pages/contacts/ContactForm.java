package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;

/**
 * This class represent Contact Form.
 */
public class ContactForm extends FormBase {

    @FindBy(css = "a[aria-label='Salutation']")
    @CacheLookup
    private WebElement salutations;

    @FindBy(css = ".uiMenuItem.uiRadioMenuItem>a")
    private List<WebElement> salutdationsList;

    @FindBy(css = "input[placeholder='First Name']")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy(css = "input[placeholder='Last Name']")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy(css = "input[placeholder='Search Accounts']")
    @CacheLookup
    private WebElement accountNameField;

    @FindBy(xpath = "//span[text()='Title']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement titleField;

    @FindBy(xpath = "//span[text()='Department']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement departmentField;

    @FindBy(xpath = "//span[text()='Birthdate']/parent::label/following-sibling::div/child::input")
    @CacheLookup
    private WebElement birthDateField;

    @FindBy(xpath = "//span[text()='Reports To']/parent::label/following-sibling::div/descendant::input")
    @CacheLookup
    private WebElement reportToField;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement phoneField;
    @FindBy(xpath = "//span[text()='Home Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement homePhoneField;
    @FindBy(xpath = "//span[text()='Mobile']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement mobilePhoneField;
    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement fax;
    @FindBy(xpath = "//span[text()='Other Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement otherPhone;

    @FindBy(xpath = "//span[text()='Email']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement mailField;

    @FindBy(xpath = "//span[text()='Assistant']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement assistandField;

    @FindBy(xpath = "//span[text()='Asst. Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement assitandPhoneFiled;

    @FindBy(css = "a[aria-label='Lead Source']")
    @CacheLookup
    private WebElement leadSourceField;

    @FindBy(css = "li.uiRadioMenuItem")
    private List<WebElement> leadList;

    @FindBy(css = "textarea[placeholder='Mailing Street']")
    @CacheLookup
    private WebElement mailingStreetField;

    @FindBy(css = "textarea[placeholder='Other Street']")
    @CacheLookup
    private WebElement otherStreetField;

    @FindBy(css = "input[placeholder='Mailing City']")
    @CacheLookup
    private WebElement mailingCity;

    @FindBy(css = "input[placeholder='Mailing State/Province']")
    @CacheLookup
    private WebElement mailingStateProvinceField;

    @FindBy(css = "input[placeholder='Other City']")
    @CacheLookup
    private WebElement otherCityFiled;

    @FindBy(css = "input[placeholder='Other State/Province']")
    @CacheLookup
    private WebElement otherStateProvinceField;

    @FindBy(css = "input[placeholder='Mailing Zip/Postal Code']")
    @CacheLookup
    private WebElement mailingZipPostalCodeField;

    @FindBy(css = "input[placeholder='Mailing Country']")
    @CacheLookup
    private WebElement mailingCountryField;

    @FindBy(css = "input[placeholder='Other Zip/Postal Code']")
    @CacheLookup
    private WebElement otherZipPostalCodeField;

    @FindBy(css = "input[placeholder='Other Country']")
    @CacheLookup
    private WebElement otherCountryField;

    @FindBy(xpath = "//span[text()='Languages']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement languagesField;

    @FindBy(css = "a[aria-label='Level']")
    @CacheLookup
    private WebElement levelCombo;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement decriptionField;


    @FindBy(xpath = "//input[@tabindex='33']")
    @CacheLookup
    private WebElement cancelBtnField;


    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm selectFirstNameCategory(final String item) {
        CommonActions.clickElement(salutations);
        CommonActions.selectAnElement(salutdationsList, item).click();
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return @return {@link ContactForm}.
     */
    public ContactForm setContactNameField(final String text) {
        CommonActions.sendKeys(firstNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setLastName(final String text) {
        CommonActions.sendKeys(lastNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setAccountName(final String text) {
        CommonActions.sendKeys(accountNameField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setTitle(final String text) {
        CommonActions.sendKeys(titleField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param text a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setDepartment(final String text) {
        CommonActions.sendKeys(departmentField, text);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param date a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setBirthDate(final String date) {
        CommonActions.sendKeys(birthDateField, date);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param mail a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setMail(final String mail) {
        CommonActions.sendKeys(mailField, mail);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param mailingStreet a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setMailingStreet(final String mailingStreet) {
        CommonActions.sendKeys(mailingStreetField, mailingStreet);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param otherStreet a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherStreet(final String otherStreet) {
        CommonActions.sendKeys(otherStreetField, otherStreet);
        return this;
    }

    /**
     * This method is to select name category.
     *
     * @param item a string to select.
     * @return {@link ContactForm}.
     */
    public ContactForm selectLeadSource(final String item) {
        CommonActions.clickElement(leadSourceField);
        CommonActions.selectAnElement(salutdationsList, item).click();
        return this;
    }

    /**
     * Method.
     *
     * @param phone is the phone to set.
     * @return {@link ContactForm}.
     */
    public ContactForm setPhone(final String phone) {
        CommonActions.sendKeys(phoneField, phone);
        return this;
    }

    /**
     * Method.
     *
     * @param phoneHome phone.
     * @return {@link ContactForm}.
     */

    public ContactForm sethomePhone(final String phoneHome) {
        CommonActions.sendKeys(homePhoneField, phoneHome);
        return this;
    }

    /**
     * Method.
     *
     * @param mobilePhone phone.
     * @return {@link ContactForm}.
     */

    public ContactForm setMobilePhone(final String mobilePhone) {
        CommonActions.sendKeys(mobilePhoneField, mobilePhone);
        return this;
    }

    /**
     * Method.
     *
     * @param item nis the phone
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherPhone(final String item) {
        CommonActions.sendKeys(otherPhone, item);
        return this;
    }

    /**
     * Method.
     *
     * @param item name
     * @return {@link ContactForm}.
     */
    public ContactForm setAssistant(final String item) {
        CommonActions.sendKeys(assistandField, item);
        return this;
    }

    /**
     * Method.
     *
     * @param item text.
     * @return {@link ContactForm}.
     */
    public ContactForm setAssistantPhone(final String item) {
        CommonActions.sendKeys(assitandPhoneFiled, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setMailingCity(final String item) {
        CommonActions.sendKeys(mailingCity, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setMalingState(final String item) {
        CommonActions.sendKeys(mailingStateProvinceField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherCity(final String item) {
        CommonActions.sendKeys(otherCityFiled, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */

    public ContactForm setMailingZip(final String item) {
        CommonActions.sendKeys(mailingZipPostalCodeField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setMailingCoutry(final String item) {
        CommonActions.sendKeys(mailingCountryField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherZip(final String item) {
        CommonActions.sendKeys(otherZipPostalCodeField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item text.
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherState(final String item) {
        CommonActions.sendKeys(otherStateProvinceField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item text.
     * @return {@link ContactForm}.
     */
    public ContactForm setOtherCountry(final String item) {
        CommonActions.sendKeys(otherCountryField, item);
        return this;
    }

    /**
     * method.
     *
     * @param item mail.
     * @return {@link ContactForm}.
     */
    public ContactForm setLanguages(final String item) {
        CommonActions.sendKeys(languagesField, item);
        return this;
    }

    /**
     * Method.
     * @param item string.
     * @return a instance of the ContactFrom class.
     */
    public ContactForm setLevel(final String item) {
        CommonActions.clickElement(levelCombo);
        CommonActions.selectAnElement(salutdationsList, item).click();
        return this;
    }


    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactsDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);
        return new ContactsDetail();
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public ContactsDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new ContactsDetail();
    }

    /**
     * Method that to permit set values to create a new Contact Home.
     *
     * @param values a map to set of the strategy.
     * @return a Map with the values of the opportunity create.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(ContactFields.FIRST_NAME_CATEGORY.getValue(),
                () -> selectFirstNameCategory(values.get(ContactFields.FIRST_NAME_CATEGORY.getValue())));
        strategyMap.put(ContactFields.CONTACT_NAME.getValue(),
                () -> setContactNameField(values.get(ContactFields.CONTACT_NAME.getValue())));
        strategyMap.put(ContactFields.LAST_NAME.getValue(),
                () -> setLastName(values.get(ContactFields.LAST_NAME.getValue())));
        strategyMap.put(ContactFields.TITLE.getValue(),
                () -> setTitle(values.get(ContactFields.TITLE.getValue())));
        strategyMap.put(ContactFields.DEPARTMENT.getValue(),
                () -> setDepartment(values.get(ContactFields.DEPARTMENT.getValue())));
        strategyMap.put(ContactFields.BIRTH_DATE.getValue(),
                () -> setBirthDate(values.get(ContactFields.BIRTH_DATE.getValue())));
        strategyMap.put(ContactFields.LEAD_SOURCE.getValue(),
                () -> selectLeadSource(values.get(ContactFields.LEAD_SOURCE.getValue())));
        strategyMap.put(ContactFields.MAIL.getValue(),
                () -> setMail(values.get(ContactFields.MAIL.getValue())));
        strategyMap.put(ContactFields.MAILING_STREET.getValue(),
                () -> setMailingStreet(values.get(ContactFields.MAILING_STREET.getValue())));
        strategyMap.put(ContactFields.OTHER_STREET.getValue(),
                () -> setOtherStreet(values.get(ContactFields.OTHER_STREET.getValue())));
        strategyMap.put(ContactFields.PHONE.getValue(),
                () -> setPhone(values.get(ContactFields.PHONE.getValue())));
        strategyMap.put(ContactFields.HOME_PHONE.getValue(),
                () -> sethomePhone(values.get(ContactFields.HOME_PHONE.getValue())));
        strategyMap.put(ContactFields.MOBILE.getValue(),
                () -> setMobilePhone(values.get(ContactFields.MOBILE.getValue())));
        strategyMap.put(ContactFields.OTHER_PHONE.getValue(),
                () -> setOtherPhone(values.get(ContactFields.OTHER_PHONE.getValue())));
        strategyMap.put(ContactFields.ASSISTANT.getValue(),
                () -> setAssistant(values.get(ContactFields.ASSISTANT.getValue())));
        strategyMap.put(ContactFields.ASSISTANT_PHONE.getValue(),
                () -> setAssistantPhone(values.get(ContactFields.ASSISTANT_PHONE.getValue())));
        strategyMap.put(ContactFields.MAILING_CITY.getValue(),
                () -> setMailingCity(values.get(ContactFields.MAILING_CITY.getValue())));
        strategyMap.put(ContactFields.MAILING_STATE.getValue(),
                () -> setMalingState(values.get(ContactFields.MAILING_STATE.getValue())));
        strategyMap.put(ContactFields.OTHER_CITY.getValue(),
                () -> setOtherCity(values.get(ContactFields.OTHER_CITY.getValue())));
        strategyMap.put(ContactFields.MAILING_ZIP.getValue(),
                () -> setMailingZip(values.get(ContactFields.MAILING_ZIP.getValue())));
        strategyMap.put(ContactFields.MAILING_COUNTRY.getValue(),
                () -> setMailingCoutry(values.get(ContactFields.MAILING_COUNTRY.getValue())));
        strategyMap.put(ContactFields.OTHER_ZIP.getValue(),
                () -> setOtherZip(values.get(ContactFields.OTHER_ZIP.getValue())));
        strategyMap.put(ContactFields.OTHER_STATE.getValue(),
                () -> setOtherState(values.get(ContactFields.OTHER_STATE.getValue())));
        strategyMap.put(ContactFields.OTHER_COUNTRY.getValue(),
                () -> setOtherCountry(values.get(ContactFields.OTHER_COUNTRY.getValue())));
        strategyMap.put(ContactFields.LANGUAGES.getValue(),
                () -> setLanguages(values.get(ContactFields.LANGUAGES.getValue())));
        strategyMap.put(ContactFields.LEVEL.getValue(),
                () -> setLevel(values.get(ContactFields.LEVEL.getValue())));
        return strategyMap;
    }

    /**
     * This method loads data to fill the form for a given Json file.
     *
     * @param valuesMapCreate Map with the json values.
     */
    public void fillTheForm(final Map<String, String> valuesMapCreate) {
        valuesMapCreate.keySet()
                .forEach(step -> getStrategyStepMap(valuesMapCreate).get(step).executeStep());
    }
}
