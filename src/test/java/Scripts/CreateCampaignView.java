package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Campaigns.CampaignView;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;

public class CreateCampaignView {
	
    private CampaignsHome campaignHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewCampaignForm campaignForm;
    private String campaignViewName = "testCampaignView1";
    private String campaignViewUniqueName = "testCampaignUniqueView1";
    private CampaignView campaignView;
    
    @BeforeMethod
	public void login() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        campaignHome = tabBar.clickCampaigns();    
	}
	
	@Test
	public void createCampaignViewTest(){
		
		campaignForm = (NewCampaignForm) campaignHome.clickNewViewLnk().setViewName(campaignViewName).setViewUniqueName(campaignViewUniqueName);
		campaignView = campaignForm.clickSaveBtn();
		Assert.assertTrue(campaignView.isViewDisplayed(), "Campaign View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteCampaignView() {
		campaignView.deleteView();
		
	}	
	

}
