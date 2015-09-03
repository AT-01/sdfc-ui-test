package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Contacts.ContactView;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.NewContactForm;

public class CreateContactView {
	
	private ContactsHome contactHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewContactForm contactForm;
    private String contactViewName = "testContactView1";
    private String contactViewUniqueName = "testContactUniqueView1";
    private ContactView contactView;
    
    @BeforeMethod
	public void login() {
    	
    	mainApp = new MainApp();  
        tabBar = mainApp.goToTabBar();
        contactHome = tabBar.clickContacts();    
	}
	
	@Test
	public void creatContactViewTest(){
		
		contactForm = (NewContactForm) contactHome.clickNewViewLnk().setViewName(contactViewName).setViewUniqueName(contactViewUniqueName);
		contactView = contactForm.clickSaveBtn();
		Assert.assertTrue(contactView.isViewDisplayed(), "Contact View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteContactView() {
		contactView.deleteView();
		
	}	

}
