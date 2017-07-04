package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * Class that verify the account edition after an account was created using a json file.
 */
public class EditAccount {

    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";
    private static final String ACCOUNT_DATA_EDIT_PATH = "account/EditAccountData.json";
    private static final String ACCOUNT_NAME = "Builder Test Account Name";
    private static final String ACCOUNT_NUMBER = "654321";
    private static final String ACCOUNT_SITE = "Builder Test Account Site";
    private static final String TYPE = "Installation Partner";
    private static final String INDUSTRY = "Engineering";
    private static final String ANNUAL_REVENUE = "99";
    private static final String RATING = "Hot";
    private static final String PHONE = "+(591)77126720";
    private static final String FAX = "987654321";
    private static final String WEBSITE = "http://www.mydomain-builder.com";
    private static final String TICKER_SYMBOL = "Builder Ticker Test";
    private static final String OWNERSHIP = "Public";
    private static final String EMPLOYEES = "9";
    private static final String SIC_CODE = "987654321";
    private static final String BILLING_STREET = "Builder Test Billing Street";
    private static final String SHIPPING_STREET = "Builder Test Shipping Street";
    private static final String CUSTOMER_PRIORITY = "Low";
    private static final String SLA_EXPIRATION_DATE = "8/29/2017";
    private static final String SLA = "Silver";
    private static final String SLA_SERIAL = "9876543210";
    private static final String NUMBER_LOCATIONS = "10";
    private static final String ACTIVE = "No";
    private static final String UPSELL_OPPORTUNITY = "Yes";
    private static final String DESCRIPTION = "Builder Test Description!!!!!!";
    private AccountDetail accountDetail;
    private AccountForm accountForm;

    /**
     * This method is the preconditions to edit an account.
     */
    @BeforeMethod
    public void setUp() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        accountForm = Navigator.goToAppLauncher()
                .clickOnAccountsHome().clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
    }

    /**
     * Test to verify the correct edition of an account using a json file.
     */
    @Test
    public void editAccountJson() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_EDIT_PATH);

        accountForm = accountDetail.clickEditButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        accountDetail.clickDetailsLink();

        assertDetailValues(accountDetail, valuesMapJson);
    }

    /**
     * Test to verify the correct edition of an account using the AccountBuilder class.
     */
    @Test
    public void editAccountBuilder() {
        accountForm = accountDetail.clickEditButton();
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
     * Delete the account recently created.
     */
    @AfterMethod
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
