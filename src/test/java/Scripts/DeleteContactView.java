package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Contacts.ContactView;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.NewContactForm;

public class DeleteContactView {
	
	private ContactsHome contactHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewContactForm contactForm;
    private String contactViewName = "testContactDelete";
    private String contactViewUniqueName = "testContactUniqueDelete";
    private ContactView contactView;
    
    @BeforeMethod
	public void createContactView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        contactHome = tabBar.clickContacts();
        contactForm = (NewContactForm) contactHome.clickNewViewLnk().setViewName(contactViewName).setViewUniqueName(contactViewUniqueName);
		contactView = contactForm.clickSaveBtn();
	}
	
	@Test
	public void deleteContactViewTest(){
		contactView.deleteView();
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    contactHome = tabBar.clickContacts();
		Assert.assertFalse(contactView.isViewDisplayed(), "Contact View Deleted");	
		 
	}

}
