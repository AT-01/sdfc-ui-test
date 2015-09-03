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

public class EditLeadView {
	
	private LeadHome leadHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewLeadForm leadForm;
    private String leadViewName = "testEditLeadEdit";
    private String leadViewUniqueName = "testEditLeadUniqueEdit";  
    private String leadEditedViewName = "testEditleadView123";
    private String leadEditedViewUniqueName = "testEditLeadUniqueView123";
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
	public void editLeadViewTest(){
		leadForm = leadView.clickEditLnk();
		leadForm.setViewName(leadEditedViewName).setViewUniqueName(leadEditedViewUniqueName);
		leadView = leadForm.clickSaveBtn();
		Assert.assertTrue(leadView.isViewDisplayed(), "Lead View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteLeadView() {
		leadView.deleteView();
		
	}	

}
