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

public class EditContactView {
	
	private ContactsHome contactHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewContactForm contactForm;
    private String contactViewName = "testEditContactEdit";
    private String contactViewUniqueName = "testEditContactUniqueEdit";  
    private String contactEditedViewName = "testEditContactView123";
    private String contactEditedViewUniqueName = "testEditContactUniqueView123";
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
	public void editContactViewTest(){
		contactForm = contactView.clickEditLnk();
		contactForm.setViewName(contactEditedViewName).setViewUniqueName(contactEditedViewUniqueName);
		contactView = contactForm.clickSaveBtn();
		Assert.assertTrue(contactView.isViewDisplayed(), "Contact View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteContactView() {
		contactView.deleteView();
		
	}	

}
