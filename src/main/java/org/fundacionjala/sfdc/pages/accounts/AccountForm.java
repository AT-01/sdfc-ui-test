package org.fundacionjala.sfdc.pages.accounts;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.FormSteps;
import org.fundacionjala.sfdc.pages.base.FormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NUMBER;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_SITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ANNUAL_REVENUE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.BILLING_STREET;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.DESCRIPTION;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.EMPLOYEES;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.FAX;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.NUMBER_LOCATIONS;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.PHONE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SHIPPING_STREET;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SIC_CODE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SLA_EXPIRATION_DATE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SLA_SERIAL;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.TICKER_SYMBOL;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.TYPE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.WEBSITE;

/**
 * It is the account base page, abstract class.
 */
public class AccountForm extends FormBase {

    //account form fields
    @FindBy(xpath = "//span[text()='Account Name']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement nameTextField;

    @FindBy(xpath = "//span[text()='Account Number']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement accountNumberTextField;

    @FindBy(xpath = "//span[text()='Account Site']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement siteTextField;

    @FindBy(xpath = "//span[text()='Phone']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement phoneTextField;

    @FindBy(xpath = "//span[text()='Website']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement websiteTextField;

    @FindBy(xpath = "//span[text()='Employees']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement employeesTextField;

    @FindBy(css = "[aria-label='Type']")
    @CacheLookup
    private WebElement typeDropDownList;

    @FindBy(css = "div.visible.positioned li.uiMenuItem.uiRadioMenuItem>a")
    private List<WebElement> dropDownList;

    @FindBy(xpath = "//span[text()='Annual Revenue']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement annualTextField;

    @FindBy(xpath = "//span[text()='Fax']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement faxTextField;

    @FindBy(xpath = "//span[text()='Ticker Symbol']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement tickerTextField;

    @FindBy(xpath = "//span[text()='SIC Code']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement sicCodeTextField;

    @FindBy(xpath = "//span[text()='Billing Street']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement billingStreetTextArea;

    @FindBy(xpath = "//span[text()='Shipping Street']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement shippingStreetTextArea;

    @FindBy(xpath = "//span[text()='SLA Expiration Date']/parent::label/following-sibling::div/input")
    @CacheLookup
    private WebElement slaExpirationDateField;

    @FindBy(xpath = "//span[text()='SLA Serial Number']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement slaSerialNumberTextField;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::label/following-sibling::input")
    @CacheLookup
    private WebElement numberOfLocationsTextField;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    @CacheLookup
    private WebElement descriptionTextAreaTextField;

    private AccountBuilder accountBuilder;

    private Map<String, String> valuesMap;

    /**
     * Constructor that call the parent constructor.
     */
    AccountForm() {
        super();
    }

    /**
     * Private constructor.
     *
     * @param accountBuilder AccountBuilder class.
     */
    private AccountForm(final AccountBuilder accountBuilder) {
        valuesMap = new HashMap<>();
        this.accountBuilder = accountBuilder;
    }

    /**
     * This method save a new account on "AccountFields" form.
     *
     * @return {@link AccountDetail}
     */
    public AccountDetail saveAccount() {
        valuesMap = accountBuilder.getStrategyMap();
        fillTheForm(valuesMap);
        return clickSaveButton();
    }

    /**
     * This method obtains values the Map set.
     *
     * @return A map with values set on "account" form.
     */
    public Map<String, String> getValuesMap() {
        return valuesMap;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDetail clickSaveButton() {
        CommonActions.clickElement(saveButton);

        return new AccountDetail();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountDetail clickSaveNewButton() {
        CommonActions.clickElement(saveNewBtn);
        return new AccountDetail();
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

    /**
     * Method that to permit set values to create a new AccountHome.
     *
     * @param values a map to set of the strategy
     * @return a Map with the values of the account created.
     */
    private Map<String, FormSteps> getStrategyStepMap(final Map<String, String> values) {
        final Map<String, FormSteps> strategyMap = new HashMap<>();

        strategyMap.put(ACCOUNT_NAME.toString(), () -> setNameTextField(values.get(ACCOUNT_NAME.toString())));
        strategyMap.put(ACCOUNT_NUMBER.toString(),
                () -> setAccountNumberTextField(values.get(ACCOUNT_NUMBER.toString())));
        strategyMap.put(ACCOUNT_SITE.toString(), () -> setSiteTextField(values.get(ACCOUNT_SITE.toString())));
        strategyMap.put(TYPE.toString(), () -> setTypeDropDownList(values.get(TYPE.toString())));
        strategyMap.put(ANNUAL_REVENUE.toString(), () -> setAnnualTextField(values.get(ANNUAL_REVENUE.toString())));
        strategyMap.put(PHONE.toString(), () -> setPhoneTextField(values.get(PHONE.toString())));
        strategyMap.put(FAX.toString(), () -> setFaxTextField(values.get(FAX.toString())));
        strategyMap.put(WEBSITE.toString(), () -> setWebsiteTextField(values.get(WEBSITE.toString())));
        strategyMap.put(TICKER_SYMBOL.toString(), () -> setTickerTextField(values.get(TICKER_SYMBOL.toString())));
        strategyMap.put(EMPLOYEES.toString(),
                () -> setEmployeesTextField(values.get(EMPLOYEES.toString())));
        strategyMap.put(SIC_CODE.toString(), () -> setSicCodeTextField(values.get(SIC_CODE.toString())));
        strategyMap.put(BILLING_STREET.toString(),
                () -> setBillingStreetTextArea(values.get(BILLING_STREET.toString())));
        strategyMap.put(SHIPPING_STREET.toString(),
                () -> setShippingStreetTextArea(values.get(SHIPPING_STREET.toString())));
        strategyMap.put(SLA_EXPIRATION_DATE.toString(),
                () -> setSlaExpirationDateField(values.get(SLA_EXPIRATION_DATE.toString())));
        strategyMap.put(SLA_SERIAL.toString(),
                () -> setSlaSerialNumberTextField(values.get(SLA_SERIAL.toString())));
        strategyMap.put(NUMBER_LOCATIONS.toString(),
                () -> setNumberOfLocations(values.get(NUMBER_LOCATIONS.toString())));
        strategyMap.put(DESCRIPTION.toString(),
                () -> setDescriptionTextAreaTextField(values.get(DESCRIPTION.toString())));

        return strategyMap;
    }

    /**
     * This method set the account name in the text field.
     *
     * @param accountName String with the account name.
     * @return Return this class.
     */
    public AccountForm setNameTextField(final String accountName) {
        CommonActions.sendKeys(nameTextField, accountName);
        return this;
    }

    /**
     * This method set the account number in the text field.
     *
     * @param accountNumber String with the account number.
     * @return Return this class.
     */
    private AccountForm setAccountNumberTextField(final String accountNumber) {
        CommonActions.sendKeys(accountNumberTextField, accountNumber);
        return this;
    }

    /**
     * This method select one specific element from a dropDownList.
     *
     * @param element String with the element.
     * @return Return this class.
     */
    private AccountForm setTypeDropDownList(final String element) {
        CommonActions.clickElement(typeDropDownList);
        CommonActions.selectAnElement(dropDownList, element).click();
        return this;
    }

    /**
     * This method set the annual revenue in the text field.
     *
     * @param annualRevenue String with the annual revenue.
     * @return Return this class.
     */
    private AccountForm setAnnualTextField(final String annualRevenue) {
        CommonActions.sendKeys(annualTextField, annualRevenue);
        return this;
    }

    /**
     * This method set the fax in the text field.
     *
     * @param fax String with the fax.
     * @return Return this class.
     */
    private AccountForm setFaxTextField(final String fax) {
        CommonActions.sendKeys(faxTextField, fax);
        return this;
    }

    /**
     * This method set the ticker in the text field.
     *
     * @param ticker String with the ticker.
     * @return Return this class.
     */
    private AccountForm setTickerTextField(final String ticker) {
        CommonActions.sendKeys(tickerTextField, ticker);
        return this;
    }

    /**
     * This method set the sic code in the text field.
     *
     * @param sicCode String with the sic code.
     * @return Return this class.
     */
    private AccountForm setSicCodeTextField(final String sicCode) {
        CommonActions.sendKeys(sicCodeTextField, sicCode);
        return this;
    }

    /**
     * This method set the billing street in the text field.
     *
     * @param billingStreet String with the billing street.
     * @return Return this class.
     */
    private AccountForm setBillingStreetTextArea(final String billingStreet) {
        CommonActions.sendKeys(billingStreetTextArea, billingStreet);
        return this;
    }

    /**
     * This method set the shipping street in the text field.
     *
     * @param shippingStreet String with the shipping street.
     * @return Return this class.
     */
    private AccountForm setShippingStreetTextArea(final String shippingStreet) {
        CommonActions.sendKeys(shippingStreetTextArea, shippingStreet);
        return this;
    }

    /**
     * This method set the sla expiration date in the text field.
     *
     * @param slaExpirationDate String with the sla expiration date.
     * @return Return this class.
     */
    private AccountForm setSlaExpirationDateField(final String slaExpirationDate) {
        CommonActions.sendKeys(slaExpirationDateField, slaExpirationDate);
        return this;
    }

    /**
     * This method set the sla serial number in the text field.
     *
     * @param slaSerialNumber String with the sla serial number.
     * @return Return this class.
     */
    private AccountForm setSlaSerialNumberTextField(final String slaSerialNumber) {
        CommonActions.sendKeys(slaSerialNumberTextField, slaSerialNumber);
        return this;
    }

    /**
     * This method set the number of locations in the text field.
     *
     * @param numberOfLocations String with the number of location.
     * @return Return this class.
     */
    private AccountForm setNumberOfLocations(final String numberOfLocations) {
        CommonActions.sendKeys(numberOfLocationsTextField, numberOfLocations);
        return this;
    }

    /**
     * This method set the description in the text field.
     *
     * @param description String with the description.
     * @return Return this class.
     */
    private AccountForm setDescriptionTextAreaTextField(final String description) {
        CommonActions.sendKeys(descriptionTextAreaTextField, description);
        return this;
    }

    /**
     * This method set the account site in the text field.
     *
     * @param accountSite String with the site account name.
     * @return Return this class.
     */
    private AccountForm setSiteTextField(final String accountSite) {
        CommonActions.sendKeys(siteTextField, accountSite);
        return this;
    }

    /**
     * This method set the account phone in the text field.
     *
     * @param accountPhone String with the site account name.
     * @return Return this class.
     */
    private AccountForm setPhoneTextField(final String accountPhone) {
        CommonActions.sendKeys(phoneTextField, accountPhone);
        return this;
    }

    /**
     * This method set the account website in the text field.
     *
     * @param accountWebsite String with the site account name.
     * @return Return this class.
     */
    private AccountForm setWebsiteTextField(final String accountWebsite) {
        CommonActions.sendKeys(websiteTextField, accountWebsite);
        return this;
    }

    /**
     * This method set the account employees in the text field.
     *
     * @param accountEmployees String with the site account name.
     * @return Return this class.
     */
    private AccountForm setEmployeesTextField(final String accountEmployees) {
        CommonActions.sendKeys(employeesTextField, accountEmployees);
        return this;
    }

    /**
     * This class handle the account builder pattern.
     */
    public static class AccountBuilder {

        private Map<String, String> strategyMap;

        /**
         * Constructor the AccountBuilder class.
         *
         * @param accountName Name required by the class.
         */
        public AccountBuilder(final String accountName) {
            strategyMap = new HashMap<>();
            strategyMap.put(ACCOUNT_NAME.toString(), accountName);
        }

        /**
         * This method build the Account form.
         *
         * @return {@link AccountForm}.
         */
        public AccountForm build() {
            return new AccountForm(this);
        }

        /**
         * This method set the product's site.
         *
         * @param accountSite String with site.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setSite(final String accountSite) {
            strategyMap.put(ACCOUNT_SITE.toString(), accountSite);
            return this;
        }

        /**
         * This method set the account numbers's site.
         *
         * @param accountNumber String with account number.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setAccountNumber(final String accountNumber) {
            strategyMap.put(ACCOUNT_NUMBER.toString(), accountNumber);
            return this;
        }

        /**
         * This method set the type's site.
         *
         * @param type String with type.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setType(final String type) {
            strategyMap.put(TYPE.toString(), type);
            return this;
        }

        /**
         * This method set the annual revenue's site.
         *
         * @param annualRevenue String with annual revenue.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setAnnualRevenue(final String annualRevenue) {
            strategyMap.put(ANNUAL_REVENUE.toString(), annualRevenue);
            return this;
        }

        /**
         * This method set the fax's site.
         *
         * @param fax String with fax.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setFax(final String fax) {
            strategyMap.put(FAX.toString(), fax);
            return this;
        }

        /**
         * This method set the ticker symbol's site.
         *
         * @param tickerSymbol String with ticker symbol.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setTickerSymbol(final String tickerSymbol) {
            strategyMap.put(TICKER_SYMBOL.toString(), tickerSymbol);
            return this;
        }

        /**
         * This method set the sic code's site.
         *
         * @param sicCode String with sic code.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setSicCode(final String sicCode) {
            strategyMap.put(SIC_CODE.toString(), sicCode);
            return this;
        }

        /**
         * This method set the billing street's site.
         *
         * @param billingStreet String with billing street.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setBillingStreet(final String billingStreet) {
            strategyMap.put(BILLING_STREET.toString(), billingStreet);
            return this;
        }

        /**
         * This method set the shipping street's site.
         *
         * @param shippingStreet String with shipping street.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setShippingStreet(final String shippingStreet) {
            strategyMap.put(SHIPPING_STREET.toString(), shippingStreet);
            return this;
        }

        /**
         * This method set the sla expiration date's site.
         *
         * @param slaExpirationDate String with sla expiration date.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setSlaExpirationDate(final String slaExpirationDate) {
            strategyMap.put(SLA_EXPIRATION_DATE.toString(), slaExpirationDate);
            return this;
        }

        /**
         * This method set the sla serial number's site.
         *
         * @param slaSerialNumber String with sla serial number.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setSlaSerialNumber(final String slaSerialNumber) {
            strategyMap.put(SLA_SERIAL.toString(), slaSerialNumber);
            return this;
        }

        /**
         * This method set the number of location's site.
         *
         * @param numberOfLocations String number of locations.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setNumberOfLocations(final String numberOfLocations) {
            strategyMap.put(NUMBER_LOCATIONS.toString(), numberOfLocations);
            return this;
        }

        /**
         * This method set the description's site.
         *
         * @param description String with description.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setDescription(final String description) {
            strategyMap.put(DESCRIPTION.toString(), description);
            return this;
        }


        /**
         * This method set the account's phone.
         *
         * @param phone String with phone.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setPhone(final String phone) {
            strategyMap.put(PHONE.toString(), phone);
            return this;
        }

        /**
         * This method set the account's website.
         *
         * @param website String with website.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setWebsite(final String website) {
            strategyMap.put(WEBSITE.toString(), website);
            return this;
        }

        /**
         * This method set the account's employees.
         *
         * @param employees String with employees.
         * @return {@link AccountBuilder}
         */
        public AccountBuilder setEmployees(final String employees) {
            strategyMap.put(EMPLOYEES.toString(), employees);
            return this;
        }

        /**
         * This method set the strategyMap account.
         *
         * @return A map with values set on "account" form.
         */
        public Map<String, String> getStrategyMap() {
            return strategyMap;
        }
    }
}
