package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Leads.LeadHome;
import Pages.Leads.LeadView;
import Pages.Leads.NewLeadForm;

public class DeleteLeadView {
	
	private LeadHome leadHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewLeadForm leadForm;
    private String leadViewName = "testLeadDelete";
    private String leadViewUniqueName = "testLeadUniqueDelete";
    private LeadView leadView;
    
    @BeforeMethod
	public void createLeadView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        leadHome = tabBar.clickLeadTab();
        leadForm = (NewLeadForm) leadHome.clickNewViewLnk().setViewName(leadViewName).setViewUniqueName(leadViewUniqueName);
		leadView = leadForm.clickSaveBtn();
	}
	
	@Test
	public void deleteLeadViewTest(){
		leadView.deleteView();
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    leadHome = tabBar.clickLeadTab();
		Assert.assertFalse(leadView.isViewDisplayed(), "Lead View Deleted");	
		 
	}

}
