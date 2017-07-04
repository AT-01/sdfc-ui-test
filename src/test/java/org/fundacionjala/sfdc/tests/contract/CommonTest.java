package org.fundacionjala.sfdc.tests.contract;

import java.util.Map;
import org.fundacionjala.sfdc.pages.contracts.ContractDetail;
import org.fundacionjala.sfdc.pages.contracts.ContractForm;
import org.fundacionjala.sfdc.pages.contracts.ContractHome;

/**
 * Created by reinaldo on 04/07/2017.
 */
public class CommonTest{

    public static ContractDetail createFormContract(ContractHome contractHome,Map<String, String> valuesMapJson){
        ContractForm contractForm = contractHome.clickNewButton();
        contractForm.fillTheForm(valuesMapJson);
        ContractDetail contractDetail = contractForm.clickSaveButton();
        contractDetail.goToLinkDetail();
        return contractDetail;
    }
}
