package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityView;

public class CreateOpportunityView {
	
	private OpportunitiesHome opportunityHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewOpportunityForm opportunityForm;
    private String opportunityViewName = "testOpportunityView1";
    private String opportunityViewUniqueName = "testOpportunityUniqueView1";
    private OpportunityView opportunityView;
    
    @BeforeMethod
	public void login() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        opportunityHome = tabBar.clickOpportunityTab();    
	}
	
	@Test
	public void createOpportunityViewTest(){
		
		opportunityForm = (NewOpportunityForm) opportunityHome.clickNewViewLnk().setViewName(opportunityViewName).setViewUniqueName(opportunityViewUniqueName);
		opportunityView = opportunityForm.clickSaveBtn();
		Assert.assertTrue(opportunityView.isViewDisplayed(), "Opportunity View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteOpportunityView() {
		opportunityView.deleteView();
		
	}	

}
