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

public class EditCampaignView {
	
	private CampaignsHome campaignHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewCampaignForm campaignForm;
    private String campaignViewName = "testEditCampaignEdit";
    private String campaignViewUniqueName = "testEditCampaignUniqueEdit";  
    private String campaignEditedViewName = "testEditCampaignView123";
    private String campaignEditedViewUniqueName = "testEditCampaignUniqueView123";
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
	public void editCampaignViewTest(){
		campaignForm = campaignView.clickEditLnk();
		campaignForm.setViewName(campaignEditedViewName).setViewUniqueName(campaignEditedViewUniqueName);
		campaignView = campaignForm.clickSaveBtn();
		Assert.assertTrue(campaignView.isViewDisplayed(), "Campaign View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteCampaignView() {
		campaignView.deleteView();
		
	}	


}
