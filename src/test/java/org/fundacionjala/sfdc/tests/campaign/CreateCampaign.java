package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * Create a campaign using a builder and Json File.
 */
public class CreateCampaign {

    private CampaignForm campaignForm;
    private CampaignDetail campaignDetail;
    private CampaignsHome campaignsHome;
    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";
    private Map<String, String> valuesMapJson;

    /**
     * Setup the Test crating a Parent campaign for a test.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        MainApp mainApp = new MainApp();
        AppLauncher appLauncher = mainApp.clickAppLauncher();
        campaignsHome = appLauncher.clickCampaigns();
    }

    /**
     * Create a campaign using  a Json file.
     */
    @Test()
    public void createCampaignWithJson() {
        campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
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
                .build();
        campaignDetail = campaigns.createCampaign();
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
