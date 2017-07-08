package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;

import static org.testng.Assert.assertFalse;

/**
 * This class is in charge to Eliminate a campaign.
 */
public class DeleteCampaign {

    private static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";

    private CampaignDetail campaignDetail;

    private CampaignsHome campaignsHome;

    private CampaignForm campaignForm;

    private Map<String, String> valuesMapJson;

    /**
     * Setup de test creating a campaign.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
//        LoginPage.loginAsPrimaryUser();
        campaignsHome = Navigator.goToCampaign();
        campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
    }

    /**
     * Eliminate the campaign and do the test.
     */
    @Test()
    public void deleteCampaign() {
        campaignDetail.clickDeleteButton();
        assertFalse(campaignDetail.isCampaignDisplayed(valuesMapJson.get("campaignName")), "NewCampaign is deleted");
    }

}
