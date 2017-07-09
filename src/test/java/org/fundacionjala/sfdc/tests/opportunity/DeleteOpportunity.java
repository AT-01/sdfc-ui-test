package org.fundacionjala.sfdc.tests.opportunity;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityDetail;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityForm;
import org.fundacionjala.sfdc.pages.opportunities.OpportunityHome;

import static org.fundacionjala.sfdc.pages.opportunities.OpportunityFields.OPPORTUNITY_NAME;
import static org.testng.Assert.assertFalse;

/**
 * This class is a test to edit and delete of a opportunity.
 */
public class DeleteOpportunity {

    private OpportunityForm opportunityForm;
    private OpportunityDetail opportunityDetail;
    private Map<String, String> valuesMapJson;
    private OpportunityHome opportunityHome;

    // private OpportunityHome opportunityHome;

    /**
     * This method is a preconditions to edit and delete a opportunity.
     */
    @BeforeMethod
    public void beforeTest() {

        valuesMapJson = JsonMapper.getMapJson(CreateOpportunity.OPPORTUNITY_DATA_PATH);

        opportunityHome = Navigator.goToOpportunity();
        opportunityForm = opportunityHome.clickNewButton();
        opportunityForm.fillTheForm(valuesMapJson);
        opportunityDetail = opportunityForm.clickSaveButton();

    }

    /**
     * This a test to delete a opportunities.
     */
    @Test
    public void deleteOpportunity() {
        opportunityDetail.clickDeleteButton();
        assertFalse(opportunityDetail.isOpportunityDisplayed(valuesMapJson.get(OPPORTUNITY_NAME.toString())));
    }


}
