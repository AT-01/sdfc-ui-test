package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.Campaigns;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.fundacionjala.sfdc.tests.Asserts;

/**
 * Update a campaign created.
 */
public class UpdateCampaign {

    private static final String CAMPAIGN_UPDATE_CAMPAIGN_DATA = "campaign/UpdateCampaignData.json";

    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";

    private CampaignDetail campaignDetail;

    private CampaignForm campaignForm;

    private CampaignsHome campaignsHome;

    /**
     * Setup the Campaign that will be updated.
     */
    @BeforeMethod()
    public void setup() {
        Map<String, String> valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        campaignsHome = Navigator.goToCampaign();
        campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
    }

    /**
     * Update a Campaign using a Json file.
     */
    @Test()
    public void updateCampaignWithJson() {
        Map<String, String> valuesMapEditJson = JsonMapper.getMapJson(CAMPAIGN_UPDATE_CAMPAIGN_DATA);
        campaignForm = campaignDetail.clickEditButton();
        campaignForm.fillTheForm(valuesMapEditJson);
        campaignDetail = campaignForm.clickSaveButton();
        campaignDetail.clickDetails();
        Asserts.assertDetailValues(campaignDetail, valuesMapEditJson);
    }

    /**
     * Update a Campaign using the Builder Pattern.
     */
    @Test()
    public void editProduct() {
        campaignForm = campaignDetail.clickEditButton();
        Campaigns campaigns = new Campaigns.CampaignBuilder("UpdatedWhitBuilder")
                .setTypeDropDown("Direct Mail")
                .setStatusDropDown("Completed")
                .build();
        campaignDetail = campaigns.createCampaign();
        campaignDetail.clickDetails();
        Asserts.assertDetailValues(campaignDetail, campaigns.getValuesMap());
    }

    /**
     * Delete the created campaign.
     */
    @AfterMethod()
    public void afterTest() {
        campaignsHome = campaignDetail.clickDeleteButton();
    }

}
