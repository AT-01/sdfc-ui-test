package org.fundacionjala.sfdc.tests.contract;

import java.util.HashMap;
import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.accounts.AccountDetail;
import org.fundacionjala.sfdc.pages.accounts.AccountForm;
import org.fundacionjala.sfdc.pages.accounts.AccountHome;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractFields;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.tests.Asserts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * This class handle create a new contract.
 */
public class CreateContract {

    static final String CONTRACT_DATA_PATH = "contract/CreateContractData.json";

    private static final String STATUS = "Draft";

    private static final String CONTRACT_START_DATE = "11/1/2016";

    private static final String CONTRACT_TERM_MONTHS = "1";


    private ContractForm contractForm;

    private AccountHome accountHome;

    private AccountForm accountForm;

    private Map<String, String> valuesMapJson;

    private ContractDetail contractDetail;

    private AppLauncher appLauncher;

    private MainApp mainApp;

    private AccountDetail accountDetail;

    /**
     * This method is Before setup.
     */
    @BeforeMethod
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CONTRACT_DATA_PATH);
        Map<String, String> valuesMapAccount = new HashMap<>();
        valuesMapAccount.put(ContractFields.ACCOUNT_NAME.toString(),
                valuesMapJson.get(ContractFields.ACCOUNT_NAME.toString()));
//        accountHome = Navigator.goToAccount();
        accountForm = accountHome.clickNewButton();
        accountForm.fillTheForm(valuesMapAccount);
        accountForm.clickSaveButton();

        mainApp = new MainApp();
        appLauncher = mainApp.clickAppLauncher();
        final ContractHome contractHome = appLauncher.clickOnContractHome();
        contractForm = contractHome.clickNewButton();
    }

    /**
     * This method that is created a new contract with json.
     */
    @Test
    public void createContractWithJson() {
        contractForm.fillTheForm(valuesMapJson);
        contractDetail = contractForm.clickSaveButton();
        Asserts.assertDetailValues(contractDetail, valuesMapJson);
    }

    /**
     * This method that is created a new contract.
     */
    @Test
    public void createContract() {
        contractForm = new ContractForm.ContractBuilder(valuesMapJson.get(ContractFields.ACCOUNT_NAME.toString()),
                STATUS, CONTRACT_START_DATE, CONTRACT_TERM_MONTHS)
                .build();
        contractDetail = contractForm.saveContract();
        Asserts.assertDetailValues(contractDetail, contractForm.getValuesMap());
    }

    /**
     * This method is executed after the scenario.
     */
    @AfterMethod
    public void tearDown() {
        contractDetail.clickDeleteButton();
        appLauncher = mainApp.clickAppLauncher();
        accountHome = appLauncher.clickOnAccountsHome();
        accountDetail = accountHome.clickOnAccount(valuesMapJson.get(ContractFields.ACCOUNT_NAME.toString()));

        accountDetail.clickDeleteButton();
    }
}
