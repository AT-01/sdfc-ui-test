package org.fundacionjala.sfdc.pages.contacts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.contacts.ContactFields.BIRTH_DATE;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.CONTACT_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.DEPARTMENT;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.FIRST_NAME_CATEGORY;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.LAST_NAME;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.LEAD_SOURCE;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.MAIL;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.MAILING_STREET;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.OTHER_STREET;
import static org.fundacionjala.sfdc.pages.contacts.ContactFields.TITLE;

/**
 * This class represent Contact Form.
 */
public class ContactForm extends FormBase {

    @FindBy(css = "a[aria-label='Salutation']")
    @CacheLookup
    private WebElement salutations;

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
        CommonActions.selectItem(salutations, item);
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
        CommonActions.selectItem(leadSourceField, item);
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

        strategyMap.put(FIRST_NAME_CATEGORY.getValue(),
                () -> selectFirstNameCategory(values.get(FIRST_NAME_CATEGORY.getValue())));
        strategyMap.put(CONTACT_NAME.getValue(), () -> setContactNameField(values.get(CONTACT_NAME.getValue())));
        strategyMap.put(LAST_NAME.getValue(), () -> setLastName(values.get(LAST_NAME.getValue())));
        strategyMap.put(TITLE.getValue(), () -> setTitle(values.get(TITLE.getValue())));
        strategyMap.put(DEPARTMENT.getValue(), () -> setDepartment(values.get(DEPARTMENT.getValue())));
        strategyMap.put(BIRTH_DATE.getValue(), () -> setBirthDate(values.get(BIRTH_DATE.getValue())));
        strategyMap.put(LEAD_SOURCE.getValue(), () -> selectLeadSource(values.get(LEAD_SOURCE.getValue())));
        strategyMap.put(MAIL.getValue(), () -> setMail(values.get(MAIL.getValue())));
        strategyMap.put(MAILING_STREET.getValue(), () -> setMailingStreet(values.get(MAILING_STREET.getValue())));
        strategyMap.put(OTHER_STREET.getValue(), () -> setOtherStreet(values.get(OTHER_STREET.getValue())));

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
