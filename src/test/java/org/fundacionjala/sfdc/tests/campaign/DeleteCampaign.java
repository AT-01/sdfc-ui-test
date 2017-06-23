package org.fundacionjala.sfdc.tests.campaign;

import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.framework.utils.Navigator;
import org.fundacionjala.sfdc.pages.campaigns.CampaignDetail;
import org.fundacionjala.sfdc.pages.campaigns.CampaignForm;
import org.fundacionjala.sfdc.pages.campaigns.CampaignsHome;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;

/**
 * This class is in charge to Eliminate a campaign.
 */
public class DeleteCampaign {
    private CampaignDetail campaignDetail;
    private CampaignsHome campaignsHome;
    private Map<String, String> valuesMapJson;
    public static final String CAMPAIGN_DATA_PATH = "campaign/CreateCampaignData.json";

    /**
     * Setup de test creating a campaign.
     */
    @BeforeMethod()
    public void setup() {
        valuesMapJson = JsonMapper.getMapJson(CAMPAIGN_DATA_PATH);
        campaignsHome = Navigator.goToCampaign();
        CampaignForm campaignForm = campaignsHome.clickNewButton();
        campaignForm.fillTheForm(valuesMapJson);
        campaignDetail = campaignForm.clickSaveButton();
    }

    /**
     * Eliminate the campaign and do the test.
     */
    @Test()
    public void deleteCampaign() {
        campaignsHome = campaignDetail.clickDeleteButton();
        assertFalse(campaignsHome.existCampaign(valuesMapJson.get("campaignName")));
    }

}
