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
     * Test to verify the correct edition of an account.
     */
    @Test
    public void editAccount() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_EDIT_PATH);

        accountForm = accountDetail.clickEditButton();
        accountForm.fillTheForm(valuesMapJson);
        accountDetail = accountForm.clickSaveButton();
        accountDetail.clickDetailsLink();

        assertDetailValues(accountDetail, valuesMapJson);
    }

    /**
     * Delete the account recently created.
     */
    @AfterMethod
    public void tearDown() {
        accountDetail.clickDeleteButton();
    }
}
