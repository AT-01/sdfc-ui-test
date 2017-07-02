package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * Create a campaign using a builder and Json File.
 */
public class CreateCampaign {

    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";

    private CampaignDetail campaignDetail;

    private CampaignsHome campaignsHome;

    private Map<String, String> valuesMapJson;

    /**
     * Setup the Test creating a Parent campaign for a test.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        campaignsHome = Navigator.goToCampaign();
    }

    /**
     * Create a campaign using  a Json file.
     */
    @Test()
    public void createCampaignWithJson() {
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
        campaignDetail.clickDetails();
        Asserts.assertDetailValues(campaignDetail, valuesMapJson);
    }

    /**
     * create a campaign using the Builder pattern.
     */
    @Test()
    public void createCampaign() {
        campaignsHome.clickNewButton();
        Campaigns campaigns = new Campaigns.CampaignBuilder("builderTestNew")
                .setTypeDropDown("Email")
                .setStatusDropDown("In Progress")
                .setStartDate("10/25/2015")
                .setEndDate("10/27/2015")
                .setRevenue("1,000")
                .setBudgetedCost("1,000")
                .setActualCost("1,000")
                .setExpectedResponse("50.00%")
                .setNumSentInCampaign("10")
                .setDescription("Description Campaign")
                .build();
        campaignDetail = campaigns.createCampaign();
        campaignDetail.clickDetails();
        Asserts.assertDetailValues(campaignDetail, campaigns.getValuesMap());
    }

    /**
     * Eliminate the campaign created.
     */
    @AfterMethod()
    public void tearDown() {
        campaignsHome = campaignDetail.clickDeleteButton();
    }
}
