package org.fundacionjala.sfdc.tests.account;

import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Class that verify the account deletion after an account was created using a json file and the AccountBuilder class.
 */
public class DeleteAccount {
    private static final String ACCOUNT_DATA_PATH = "account/CreateAccountData.json";

    /**
     * This method is the preconditions to delete an account.
     */
    @BeforeMethod
    public void setup() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(ACCOUNT_DATA_PATH);
        AccountForm accountForm = Navigator.goToAccountHome().clickNewButton();
        accountForm.fillTheForm(valuesMapJson);
        accountForm.clickSaveButton();
    }

    /**
     * Test to verify the correct deletion of an account from the AccountHome page.
     */
    @Test
    public void deleteAccountFromAccountHomePage() {
        Navigator.goToAccountHome().deleteAccount();
    }
}
