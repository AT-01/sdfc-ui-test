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

public class EditOpportunityView {
	
	private OpportunitiesHome opportunityHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewOpportunityForm opportunityForm;
    private String opportunityViewName = "testEditOpportunityEdit";
    private String opportunityViewUniqueName = "testEditOpportunityUniqueEdit";  
    private String opportunityEditedViewName = "testEditOpportunityView123";
    private String opportunityEditedViewUniqueName = "testEditOpprtunityUniqueView123";
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
	public void editOpportunityViewTest(){
		opportunityForm = opportunityView.clickEditLnk();
		opportunityForm.setViewName(opportunityEditedViewName).setViewUniqueName(opportunityEditedViewUniqueName);
		opportunityView = opportunityForm.clickSaveBtn();
		Assert.assertTrue(opportunityView.isViewDisplayed(), "Opportunity View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteOpportunityView() {
		opportunityView.deleteView();
		
	}	

}
