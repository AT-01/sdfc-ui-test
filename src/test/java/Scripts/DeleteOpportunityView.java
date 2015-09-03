package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityView;

public class DeleteOpportunityView {
	
	private OpportunitiesHome opportunityHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewOpportunityForm opportunityForm;
    private String opportunityViewName = "testOpportunityView1";
    private String opportunityViewUniqueName = "testOpportunityUniqueView1";
    private OpportunityView opportunityView;
    
    @BeforeMethod
	public void createOpportunityView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        opportunityHome = tabBar.clickOpportunityTab();    
        opportunityForm = (NewOpportunityForm) opportunityHome.clickNewViewLnk().setViewName(opportunityViewName).setViewUniqueName(opportunityViewUniqueName);
		opportunityView = opportunityForm.clickSaveBtn();
	}
	
	@Test
	public void deleteOpportunityViewTest(){
		opportunityView.deleteView();
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    opportunityHome = tabBar.clickOpportunityTab();
		Assert.assertFalse(opportunityView.isViewDisplayed(), "Opportunity View Deleted");	
		 
	}

}
