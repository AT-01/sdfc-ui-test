package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;

import static org.testng.Assert.assertFalse;

/**
 * This class handle edit and deleted a contract.
 */
public class DeleteContract {

    private static final String CONTRACT_DATA_EDIT_PATH = "contract/EditContractData.json";
    private String contractNumber;

    private ContractHome contractHome;

    private ContractDetail contractDetail;

    private Map<String, String> valuesMapJson;

    /**
     *
     * This method is a preconditions to edit and delete a contract.
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

        contractNumber = contractDetail.getContractNumber();
    }

    /**
     * This a test to delete a contract.
     */
    @Test
    public void deleteContract() {
        contractDetail.clickDeleteButton();

        assertFalse(contractDetail.isContractDisplayed(contractNumber));
    }

}
