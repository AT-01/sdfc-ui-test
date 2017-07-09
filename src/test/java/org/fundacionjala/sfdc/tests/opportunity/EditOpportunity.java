package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;
import org.fundacionjala.sfdc.tests.Asserts;


/**
 * Created by Administrator on 6/30/2017.
 */
public class EditOpportunity {
    private static final String OPPORTUNITY_DATA_PATH = "opportunity/CreateOpportunityData.json";
    private static final String OPPORTUNITY_DATA_EDIT_PATH = "opportunity/EditOpportunityData.json";
    private Map<String, String> valuesMapJson;
    private OpportunityHome opportunityHome;
    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;

    /**
     * This method is a preconditions to create a opportunities.
     */
    @BeforeMethod
    public void beforeTest() {
        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_PATH);

        opportunityHome = Navigator.goToOpportunity();
        opportunityForm = opportunityHome.clickNewButton();
        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();
    }

    /**
     * This is a test to edit an opportunity.
     */
    @Test
    public void editOpportunity() {
        Map<String, String> valuesMapEditJson2 = JsonMapper.getMapJson(OPPORTUNITY_DATA_EDIT_PATH);
        opportunityForm = opportunityDetail.clickEditButton();
        opportunityForm.fillTheForm(valuesMapEditJson2);
        opportunityDetail = opportunityForm.clickSaveButton();
        opportunityDetail.clickDetails();
        Asserts.assertDetailValues(opportunityDetail, valuesMapEditJson2);
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {

        opportunityDetail.clickDeleteButton();
    }
}
