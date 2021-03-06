package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * Class that verify the creation of the account.
 */
public class CreateAccount {
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private static final String ACCOUNT_NAME = "Builder Test Account Name";
    private static final String ACCOUNT_NUMBER = "123456";
    private static final String ACCOUNT_SITE = "Builder Test Account Site";
    private static final String TYPE = "Prospect";
    private static final String INDUSTRY = "Banking";
    private static final String ANNUAL_REVENUE = "12";
    private static final String RATING = "Warm";
    private static final String PHONE = "+(591)71234567";
    private static final String FAX = "123456789";
    private static final String WEBSITE = "http://www.mydomain-builder.com";
    private static final String TICKER_SYMBOL = "Builder Ticker Test";
    private static final String OWNERSHIP = "Private";
    private static final String EMPLOYEES = "3";
    private static final String SIC_CODE = "123456789";
    private static final String BILLING_STREET = "Builder Test Billing Street";
    private static final String SHIPPING_STREET = "Builder Test Shipping Street";
    private static final String CUSTOMER_PRIORITY = "High";
    private static final String SLA_EXPIRATION_DATE = "7/29/2017";
    private static final String SLA = "Gold";
    private static final String SLA_SERIAL = "0123456789";
    private static final String NUMBER_LOCATIONS = "5";
    private static final String ACTIVE = "Yes";
    private static final String UPSELL_OPPORTUNITY = "Maybe";
    private static final String DESCRIPTION = "Builder Test Description!!!!!!";
    private AccountDetail accountDetail;
    private AccountForm accountForm;
    private Map<String, String> valuesMapJson;

    /**
     * This method is the precondition to create an account.
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        accountForm = Navigator.goToAccountHome().clickNewButton();
    }

    /**
     * Method that verify the creation of the account with json file.
     */
    @Test
    public void createAccountWithJson() {
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        accountDetail.clickDetailsLink();
        assertDetailValues(accountDetail, valuesMapJson);
    }

    /**
     * Method that verify the creation of the account using the AccountBuilder class.
     */
    @Test
    public void createAccount() {
        accountForm = new AccountForm.AccountBuilder(ACCOUNT_NAME)
                .setAccountNumber(ACCOUNT_NUMBER)
                .setSite(ACCOUNT_SITE)
                .setType(TYPE)
                .setIndustry(INDUSTRY)
                .setAnnualRevenue(ANNUAL_REVENUE)
                .setRating(RATING)
                .setPhone(PHONE)
                .setFax(FAX)
                .setWebsite(WEBSITE)
                .setTickerSymbol(TICKER_SYMBOL)
                .setOwnership(OWNERSHIP)
                .setEmployees(EMPLOYEES)
                .setSicCode(SIC_CODE)
                .setBillingStreet(BILLING_STREET)
                .setShippingStreet(SHIPPING_STREET)
                .setCustomerPriority(CUSTOMER_PRIORITY)
                .setSlaExpirationDate(SLA_EXPIRATION_DATE)
                .setSla(SLA)
                .setSlaSerialNumber(SLA_SERIAL)
                .setNumberOfLocations(NUMBER_LOCATIONS)
                .setActive(ACTIVE)
                .setUpsellOpportunity(UPSELL_OPPORTUNITY)
                .setDescription(DESCRIPTION)
                .build();
        accountDetail = accountForm.saveAccount();
        accountDetail.clickDetailsLink();
        assertDetailValues(accountDetail, accountForm.getValuesMap());
    }

    /**
     * Delete the account recently created after each test execution.
     */
    @AfterMethod
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
