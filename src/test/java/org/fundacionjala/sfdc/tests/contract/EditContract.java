package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * Created by Administrator on 6/30/2017.
 */
public class EditContract {
    private static final String CONTRACT_DATA_EDIT_PATH = "contract/EditContractData.json";

    private ContractHome contractHome;

    private ContractForm contractForm;

    private ContractDetail contractDetail;

    private Map<String, String> valuesMapJson;

    /**
     *
     * This method is a preconditions to edit and delete a contract .
     *
     */
    @BeforeMethod
    public void setUp() {
        valuesMapJson = JsonMapper.getMapJson(CreateContract.CONTRACT_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        contractHome = Navigator.goToContract();
        ContractForm contractForm = contractHome.clickNewButton();
        contractForm.fillTheForm(valuesMapJson);
        contractDetail = contractForm.clickSaveButton();
        contractDetail.goToLinkDetail();
    }

    /**
     *
     * This is a test to edit a contract.
     *
     */
    @Test
    public void editContract() {

        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CONTRACT_DATA_EDIT_PATH);
        contractForm = contractDetail.clickEditButton();
        contractForm.fillTheForm(valuesMapEditJson);
        contractDetail = contractForm.clickSaveButton();
        contractDetail.goToLinkDetail();
        Asserts.assertDetailValues(contractDetail, valuesMapEditJson);
    }

    /**
     *
     * This is a post conditions for contract test.
     *
     */
    @AfterMethod
    public void tearDown() {
        contractDetail.clickDeleteButton();
    }
}
