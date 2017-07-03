package org.fundacionjala.sfdc.tests.account;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * Class that verify the account edition after an account was created using the AccountBuilder class.
 */
public class EditAccountBuilder {
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private static final String ACCOUNT_NAME = "Builder Test Account Name";
    private static final String ACCOUNT_NUMBER = "123456";
    private static final String ACCOUNT_SITE = "Builder Test Account Site";
    private static final String TYPE = "Prospect";
    private static final String ANNUAL_REVENUE = "12";
    private static final String PHONE = "+(591)71234567";
    private static final String FAX = "123456789";
    private static final String WEBSITE = "http://www.mydomain-builder.com";
    private static final String TICKER_SYMBOL = "Ticker Test";
    private static final String EMPLOYEES = "3";
    private static final String SIC_CODE = "123456789";
    private static final String BILLING_STREET = "Builder Test Billing Street";
    private static final String SHIPPING_STREET = "Builder Test Shipping Street";
    private static final String SLA_EXPIRATION_DATE = "7/29/2017";
    private static final String SLA_SERIAL = "0123456789";
    private static final String NUMBER_LOCATIONS = "5";
    private static final String DESCRIPTION = "Builder Test Description!!!!!!";
    private static final String ACCOUNT_NAME_EDITED = "Builder Test Account Name Edited";
    private static final String ACCOUNT_NUMBER_EDITED = "7890";
    private static final String ACCOUNT_SITE_EDITED = "Builder Test Account Site Edited";
    private static final String TYPE_EDITED = "Installation Partner";
    private static final String ANNUAL_REVENUE_EDITED = "21";
    private static final String PHONE_EDITED = "+(591)01234567";
    private static final String FAX_EDITED = "987654321";
    private static final String WEBSITE_EDITED = "http://www.mydomain-builder-edited.com";
    private static final String TICKER_SYMBOL_EDITED = "Builder Ticker Test Edited";
    private static final String EMPLOYEES_EDITED = "9";
    private static final String SIC_CODE_EDITED = "987654321";
    private static final String BILLING_STREET_EDITED = "Builder Test Billing Street Edited";
    private static final String SHIPPING_STREET_EDITED = "Builder Test Shipping Street Edited";
    private static final String SLA_EXPIRATION_DATE_EDITED = "10/29/2017";
    private static final String SLA_SERIAL_EDITED = "9876543210";
    private static final String NUMBER_LOCATIONS_EDITED = "10";
    private static final String DESCRIPTION_EDITED = "Builder Test Description Edited!!!!!!";
    private AccountDetail accountDetail;
    private AccountForm accountForm;

    /**
     * This method is the preconditions to edit an account.
     */
    @Before
    public void setup() {
        LoginPage.loginAsPrimaryUser();
        accountForm = Navigator.goToAppLauncher()
                .clickOnAccountsHome().clickNewButton();
        accountForm = new AccountForm.AccountBuilder(ACCOUNT_NAME)
                .setAccountNumber(ACCOUNT_NUMBER)
                .setSite(ACCOUNT_SITE)
                .setType(TYPE)
                .setAnnualRevenue(ANNUAL_REVENUE)
                .setPhone(PHONE)
                .setFax(FAX)
                .setWebsite(WEBSITE)
                .setTickerSymbol(TICKER_SYMBOL)
                .setEmployees(EMPLOYEES)
                .setSicCode(SIC_CODE)
                .setBillingStreet(BILLING_STREET)
                .setShippingStreet(SHIPPING_STREET)
                .setSlaExpirationDate(SLA_EXPIRATION_DATE)
                .setSlaSerialNumber(SLA_SERIAL)
                .setNumberOfLocations(NUMBER_LOCATIONS)
                .setDescription(DESCRIPTION)
                .build();
        accountDetail = accountForm.saveAccount();
    }

    /**
     * Test to verify the correct edition of an account.
     */
    @Test
    public void editAccountUsingAccountBuilder() {
        accountForm = accountDetail.clickEditButton();
        accountForm = new AccountForm.AccountBuilder(ACCOUNT_NAME_EDITED)
                .setAccountNumber(ACCOUNT_NUMBER_EDITED)
                .setSite(ACCOUNT_SITE_EDITED)
                .setType(TYPE_EDITED)
                .setAnnualRevenue(ANNUAL_REVENUE_EDITED)
                .setPhone(PHONE_EDITED)
                .setFax(FAX_EDITED)
                .setWebsite(WEBSITE_EDITED)
                .setTickerSymbol(TICKER_SYMBOL_EDITED)
                .setEmployees(EMPLOYEES_EDITED)
                .setSicCode(SIC_CODE_EDITED)
                .setBillingStreet(BILLING_STREET_EDITED)
                .setShippingStreet(SHIPPING_STREET_EDITED)
                .setSlaExpirationDate(SLA_EXPIRATION_DATE_EDITED)
                .setSlaSerialNumber(SLA_SERIAL_EDITED)
                .setNumberOfLocations(NUMBER_LOCATIONS_EDITED)
                .setDescription(DESCRIPTION_EDITED)
                .build();
        accountDetail = accountForm.saveAccount();
        accountDetail.clickDetailsLink();
        assertDetailValues(accountDetail, accountForm.getValuesMap());
    }

    /**
     * Delete the account recently created.
     */
    @After
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }

}
