package org.fundacionjala.sfdc.pages.accounts;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.base.DetailBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * This class content all the Account data.
 */
public class AccountDetail extends DetailBase {

    // Account fields
    @FindBy(xpath = "//span[text()='Account Name']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountName;

    @FindBy(xpath = "//span[text()='Account Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountNumber;

    @FindBy(xpath = "//span[text()='Account Site']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountSite;

    @FindBy(xpath = "//span[text()='Type']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountType;

    @FindBy(xpath = "//span[text()='Annual Revenue']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountAnnualRevenue;

    @FindBy(xpath = "//span[text()='Phone']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountPhone;

    @FindBy(xpath = "//span[text()='Fax']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountFax;

    @FindBy(xpath = "//span[text()='Website']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountWebsite;

    @FindBy(xpath = "//span[text()='Ticker Symbol']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountTickerSymbol;

    @FindBy(xpath = "//span[text()='Employees']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountEmployees;

    @FindBy(xpath = "//span[text()='SIC Code']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountSicCode;

    @FindBy(xpath = "//span[text()='Billing Address']/parent::div/following-sibling::div/span/a/div")
    @CacheLookup
    private WebElement billingStreet;

    @FindBy(xpath = "//span[text()='Shipping Address']/parent::div/following-sibling::div/span/a/div")
    @CacheLookup
    private WebElement shippingStreet;

    @FindBy(xpath = "//span[text()='SLA Expiration Date']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement slaExpirationDate;

    @FindBy(xpath = "//span[text()='SLA Serial Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement slaSerialNumber;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement numberOfLocations;

    @FindBy(xpath = "//span[text()='Description']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement description;

    /**
     * {@inheritDoc}
     */
    @Override
    public AccountForm clickEditButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(editBtn);

        return new AccountForm();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MainApp clickDeleteButton() {
        CommonActions.clickElement(downArrow);
        CommonActions.clickElement(deleteBtn);
        CommonActions.clickElement(confirmDeleteButton);
        return new MainApp();
    }

    /**
     * Method that to permit gets texts.
     *
     * @return a Map with the values of account edit.
     */
    public Map<String, AssertsDetails> getStrategyAssertMap() {
        final Map<String, AssertsDetails> strategyMap = new HashMap<>();

        strategyMap.put(AccountFields.ACCOUNT_NAME.toString(), this::getName);
        strategyMap.put(AccountFields.ACCOUNT_NUMBER.toString(), this::getAccountNumber);
        strategyMap.put(AccountFields.ACCOUNT_SITE.toString(), this::getSite);
        strategyMap.put(AccountFields.TYPE.toString(), this::getAccountType);
        strategyMap.put(AccountFields.ANNUAL_REVENUE.toString(), this::getAccountAnnualRevenue);
        strategyMap.put(AccountFields.PHONE.toString(), this::getPhone);
        strategyMap.put(AccountFields.FAX.toString(), this::getAccountFax);
        strategyMap.put(AccountFields.TICKER_SYMBOL.toString(), this::getAccountTickerSymbol);
        strategyMap.put(AccountFields.WEBSITE.toString(), this::getWebsite);
        strategyMap.put(AccountFields.EMPLOYEES.toString(), this::getEmployees);
        strategyMap.put(AccountFields.SIC_CODE.toString(), this::getAccountSicCode);
        strategyMap.put(AccountFields.BILLING_STREET.toString(), this::getBillingStreet);
        strategyMap.put(AccountFields.SHIPPING_STREET.toString(), this::getShippingStreet);
        strategyMap.put(AccountFields.SLA_EXPIRATION_DATE.toString(), this::getSlaExpirationDate);
        strategyMap.put(AccountFields.SLA_SERIAL.toString(), this::getSlaSerialNumber);
        strategyMap.put(AccountFields.NUMBER_LOCATIONS.toString(), this::getNumberOfLocations);
        strategyMap.put(AccountFields.DESCRIPTION.toString(), this::getDescription);

        return strategyMap;
    }

    /**
     * Returns the billing street field.
     *
     * @return a String with the billing street field.
     */
    private String getBillingStreet() {
        return billingStreet.getText();
    }

    /**
     * Returns the shipping street field.
     *
     * @return a String with the shipping street field.
     */
    private String getShippingStreet() {
        return shippingStreet.getText();
    }

    /**
     * Returns the number of locations field.
     *
     * @return a String with the number of locations field.
     */
    private String getNumberOfLocations() {
        return numberOfLocations.getText();
    }

    /**
     * Returns the description field.
     *
     * @return a String with the description field.
     */
    public String getDescription() {
        return description.getText();
    }

    /**
     * Returns the account name.
     *
     * @return String with account name
     */
    public String getName() {
        return accountName.getText();
    }

    /**
     * Returns the account number field.
     *
     * @return a String with the account number field.
     */
    private String getAccountNumber() {
        return accountNumber.getText();
    }

    /**
     * Returns the account type field.
     *
     * @return a String with the account type field.
     */
    private String getAccountType() {
        return accountType.getText();
    }

    /**
     * Returns the annual revenue field.
     *
     * @return a String with the annual revenue field.
     */
    private String getAccountAnnualRevenue() {
        return accountAnnualRevenue.getText().replace("$", "");
    }

    /**
     * Returns the fax field.
     *
     * @return a String with the fax field.
     */
    private String getAccountFax() {
        return accountFax.getText();
    }

    /**
     * Returns the account ticker symbol field.
     *
     * @return a String with the ticker symbol field.
     */
    private String getAccountTickerSymbol() {
        return accountTickerSymbol.getText();
    }

    /**
     * Returns the sic code field.
     *
     * @return a String with the sic code field.
     */
    private String getAccountSicCode() {
        return accountSicCode.getText();
    }

    /**
     * Returns the sla expiration date field.
     *
     * @return a String with the sla expiration field field.
     */
    private String getSlaExpirationDate() {
        return slaExpirationDate.getText();
    }

    /**
     * Returns the sla serial number field.
     *
     * @return a String with the sla serial number field.
     */
    private String getSlaSerialNumber() {
        return slaSerialNumber.getText();
    }

    /**
     * Returns the account site.
     *
     * @return String with account site
     */
    private String getSite() {
        return accountSite.getText();
    }

    /**
     * Returns the account phone.
     *
     * @return String with account phone
     */
    private String getPhone() {
        return accountPhone.getText();
    }

    /**
     * Returns the account website.
     *
     * @return String with account website
     */
    private String getWebsite() {
        return accountWebsite.getText();
    }

    /**
     * Returns the account employees.
     *
     * @return String with account employees
     */
    private String getEmployees() {
        return accountEmployees.getText();
    }
}
