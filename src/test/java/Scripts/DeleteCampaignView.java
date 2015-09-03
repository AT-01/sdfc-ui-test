package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Campaigns.CampaignView;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;

public class DeleteCampaignView {
	
	private CampaignsHome campaignHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewCampaignForm campaignForm;
    private String campaignViewName = "testCampaignDelete";
    private String campaignViewUniqueName = "testCampaignUniqueDelete";
    private CampaignView campaignView;
    
    @BeforeMethod
	public void createCampaignView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        campaignHome = tabBar.clickCampaigns();
        campaignForm = (NewCampaignForm) campaignHome.clickNewViewLnk().setViewName(campaignViewName).setViewUniqueName(campaignViewUniqueName);
		campaignView = campaignForm.clickSaveBtn();
	}
	
	@Test
	public void deleteCampaignViewTest(){
		campaignView.deleteView();
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    campaignHome = tabBar.clickCampaigns();
		Assert.assertFalse(campaignView.isViewDisplayed(), "Campaign View Deleted");	
		 
	}
	
	

}
