package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Leads.LeadHome;
import Pages.Leads.LeadView;
import Pages.Leads.NewLeadForm;

public class CreateLeadView {
	
	private LeadHome leadHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewLeadForm leadForm;
    private String leadViewName = "testLeadView1";
    private String leadViewUniqueName = "testLeadUniqueView1";
    private LeadView leadView;
    
    @BeforeMethod
	public void login() {
    	
    	mainApp = new MainApp();
        tabBar = mainApp.goToTabBar();
        leadHome = tabBar.clickLeadTab();    
	}
	
	@Test
	public void creatLeadViewTest(){
		
		leadForm = (NewLeadForm) leadHome.clickNewViewLnk().setViewName(leadViewName).setViewUniqueName(leadViewUniqueName);
		leadView = leadForm.clickSaveBtn();
		Assert.assertTrue(leadView.isViewDisplayed(), "Lead View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteLeadView() {
		leadView.deleteView();
		
	}	

}
