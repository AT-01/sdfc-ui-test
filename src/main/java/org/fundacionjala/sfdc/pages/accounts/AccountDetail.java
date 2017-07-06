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

import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NAME;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_NUMBER;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACCOUNT_SITE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ACTIVE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.ANNUAL_REVENUE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.BILLING_STREET;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.CUSTOMER_PRIORITY;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.DESCRIPTION;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.EMPLOYEES;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.FAX;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.INDUSTRY;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.NUMBER_LOCATIONS;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.OWNERSHIP;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.PHONE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.RATING;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SHIPPING_STREET;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SIC_CODE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SLA;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SLA_EXPIRATION_DATE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.SLA_SERIAL;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.TICKER_SYMBOL;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.TYPE;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.UPSELL_OPPORTUNITY;
import static org.fundacionjala.sfdc.pages.accounts.AccountFields.WEBSITE;

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

    @FindBy(xpath = "//span[text()='Industry']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountIndustry;

    @FindBy(xpath = "//span[text()='Annual Revenue']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountAnnualRevenue;

    @FindBy(xpath = "//span[text()='Rating']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountRating;

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

    @FindBy(xpath = "//span[text()='Ownership']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement accountOwnership;

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

    @FindBy(xpath = "//span[text()='Customer Priority']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement customerPriority;

    @FindBy(xpath = "//span[text()='SLA Expiration Date']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement slaExpirationDate;

    @FindBy(xpath = "//span[text()='SLA']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement sla;

    @FindBy(xpath = "//span[text()='SLA Serial Number']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement slaSerialNumber;

    @FindBy(xpath = "//span[text()='Number of Locations']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement numberOfLocations;

    @FindBy(xpath = "//span[text()='Active']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement active;

    @FindBy(xpath = "//span[text()='Upsell Opportunity']/parent::div/following-sibling::div/span/span")
    @CacheLookup
    private WebElement upsellOpportunity;

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

        strategyMap.put(ACCOUNT_NAME.toString(), this::getName);
        strategyMap.put(ACCOUNT_NUMBER.toString(), this::getAccountNumber);
        strategyMap.put(ACCOUNT_SITE.toString(), this::getAccountSite);
        strategyMap.put(TYPE.toString(), this::getAccountType);
        strategyMap.put(INDUSTRY.toString(), this::getIndustryType);
        strategyMap.put(ANNUAL_REVENUE.toString(), this::getAnnualRevenue);
        strategyMap.put(RATING.toString(), this::getAccountRating);
        strategyMap.put(PHONE.toString(), this::getAccountPhone);
        strategyMap.put(FAX.toString(), this::getAccountFax);
        strategyMap.put(TICKER_SYMBOL.toString(), this::getAccountTickerSymbol);
        strategyMap.put(OWNERSHIP.toString(), this::getAccountOwnership);
        strategyMap.put(WEBSITE.toString(), this::getAccountWebsite);
        strategyMap.put(EMPLOYEES.toString(), this::getEmployees);
        strategyMap.put(SIC_CODE.toString(), this::getAccountSicCode);
        strategyMap.put(BILLING_STREET.toString(), this::getBillingStreet);
        strategyMap.put(SHIPPING_STREET.toString(), this::getShippingStreet);
        strategyMap.put(CUSTOMER_PRIORITY.toString(), this::getCustomerPriority);
        strategyMap.put(SLA_EXPIRATION_DATE.toString(), this::getSlaExpirationDate);
        strategyMap.put(SLA.toString(), this::getSla);
        strategyMap.put(SLA_SERIAL.toString(), this::getSlaSerialNumber);
        strategyMap.put(NUMBER_LOCATIONS.toString(), this::getNumberOfLocations);
        strategyMap.put(ACTIVE.toString(), this::getActive);
        strategyMap.put(UPSELL_OPPORTUNITY.toString(), this::getUpsellOpportunity);
        strategyMap.put(DESCRIPTION.toString(), this::getDescription);

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
     * Returns the account industry field.
     *
     * @return a String with the account industry field.
     */
    private String getIndustryType() {
        return accountIndustry.getText();
    }

    /**
     * Returns the account upsell opportunity field.
     *
     * @return a String with the upsell opportunity field.
     */
    private String getUpsellOpportunity() {
        return upsellOpportunity.getText();
    }

    /**
     * Returns the annual revenue field.
     *
     * @return a String with the annual revenue field.
     */
    private String getAnnualRevenue() {
        return accountAnnualRevenue.getText().replace("$", "");
    }

    /**
     * Returns the annual revenue field.
     *
     * @return a String with the annual revenue field.
     */
    private String getAccountRating() {
        return accountRating.getText();
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
     * Returns the account ownership field.
     *
     * @return a String with the ownership field.
     */
    private String getAccountOwnership() {
        return accountOwnership.getText();
    }

    /**
     * Returns the customer priority field.
     *
     * @return a String with the customer priority field.
     */
    private String getCustomerPriority() {
        return customerPriority.getText();
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
     * @return a String with the sla expiration field.
     */
    private String getSlaExpirationDate() {
        return slaExpirationDate.getText();
    }

    /**
     * Returns the sla field.
     *
     * @return a String with the sla field.
     */
    private String getSla() {
        return sla.getText();
    }

    /**
     * Returns the active field.
     *
     * @return a String with the active field.
     */
    private String getActive() {
        return active.getText();
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
    private String getAccountSite() {
        return accountSite.getText();
    }

    /**
     * Returns the account phone.
     *
     * @return String with account phone
     */
    private String getAccountPhone() {
        return accountPhone.getText();
    }

    /**
     * Returns the account website.
     *
     * @return String with account website
     */
    private String getAccountWebsite() {
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
