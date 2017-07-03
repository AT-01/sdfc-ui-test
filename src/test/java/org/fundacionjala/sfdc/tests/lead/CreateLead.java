package org.fundacionjala.sfdc.tests.lead;


import java.util.Map;

import org.fundacionjala.sfdc.framework.utils.JsonMapper;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.MainApp;
import org.fundacionjala.sfdc.pages.leads.LeadDetails;
import org.fundacionjala.sfdc.pages.leads.LeadForm;
import org.fundacionjala.sfdc.pages.leads.LeadHome;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fundacionjala.sfdc.tests.Asserts.assertDetailValues;

/**
 * This class verify the Creation of LeadHome.
 */
public class CreateLead {

    //private static final String CAMPAIGN_NAME = "AT-CampaignTest-01";
    private static final String LEAD_DATA_PATH = "lead/CreateLeadData.json";

    //private CampaignsHome campaignsHome;
    //private CampaignDetail campaignDetail;
    private AppLauncher appLauncher;
    private MainApp mainApp;
    private LeadHome leadHome;
    private LeadForm leadForm;
    private LeadDetails leadDetails;

    private Map<String, String> valuesMapJson;


    /**
     * This method execute the preconditions to make the validation for creation of lead,
     * in this method a campaign is created and the LINKS tab is selected.
     */
    @BeforeMethod
    public void setUp() {
        //TabBar tabBar = new TabBar();
        /*LoginPage.loginAsPrimaryUser();
        campaignsHome = Navigator.goToCampaign();
        campaignsHome.clickNewButton();
        Campaigns campaigns = new Campaigns.CampaignBuilder(CAMPAIGN_NAME).setActive("checked")
                .build();
        campaignDetail = campaigns.createCampaign();
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        //valuesMapJson.put(CAMPAIGN.toString(), CAMPAIGN_NAME);*/
        valuesMapJson = JsonMapper.getMapJson(LEAD_DATA_PATH);
        LoginPage.loginAsPrimaryUser();
        mainApp = new MainApp();
        appLauncher = mainApp.clickAppLauncher();
        leadHome = appLauncher.clickLead();
    }

    /**
     * This method create a new LeadFields and make the corresponding assertions.
     */
    @Test
    public void createLeadTest() {
        leadForm = leadHome.clickNewButton();
        leadForm.fillTheForm(valuesMapJson);
        leadDetails = leadForm.clickSaveButton();
        leadDetails.clickDetailsButton();
        assertDetailValues(leadDetails, leadForm.formatJson(valuesMapJson));

    }

    /**
     * This method delete the created Lead and also delete the created campaign.
     */
    @AfterMethod
    public void tearDown() {
        leadDetails.clickDeleteButton();
        /*campaignsHome = new AppLauncher().clickCampaigns();
        campaignDetail = campaignsHome.selectCampaign(CAMPAIGN_NAME);
        campaignDetail.clickDeleteButton();*/
    }
}


