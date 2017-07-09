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
 * This class is a test to create a opportunity.
 */
public class CreateOpportunity {

    static final String OPPORTUNITY_DATA_PATH = "opportunity/CreateOpportunityData.json";
    private OpportunityDetail opportunityDetail;
    private Map<String, String> valuesMapJson;
    private OpportunityHome opportunityHome;
    private OpportunityForm opportunityForm;


    /**
     * This method is a preconditions to create a opportunities.
     */
    @BeforeMethod
    public void beforeTest() {

        valuesMapJson = JsonMapper.getMapJson(OPPORTUNITY_DATA_PATH);

        opportunityHome = Navigator.goToOpportunity();

    }

    /**
     * This a test to create a opportunities.
     */
    @Test
    public void createOpportunity() {

        opportunityForm = opportunityHome.clickNewButton();
        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();
        opportunityDetail.clickDetails();
        Asserts.assertDetailValues(opportunityDetail, valuesMapJson);
    }

    /**
     * This a post conditions a opportunities.
     */
    @AfterMethod
    public void afterTest() {

        opportunityDetail.clickDeleteButton();
    }
}
