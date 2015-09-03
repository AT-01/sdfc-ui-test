package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Accounts.AccountView;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;

public class EditAccountView {
	
	private AccountsHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewAccountForm accountForm;
    private String accountViewName = "testEditAccountEdit";
    private String accountViewUniqueName = "testEditAccountUniqueEdit";  
    private String accountEditedViewName = "testEditAccountView123";
    private String accountEditedViewUniqueName = "testEditAccountUniqueView123";
    private AccountView  accountView;
    
    @BeforeMethod
	public void createAccountView() {
    	
    	mainApp = new MainApp();  
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickAccountsTab(); 
        accountForm = (NewAccountForm) accountHome.clickNewViewLnk().setViewName(accountViewName).setViewUniqueName(accountViewUniqueName);
		accountView = accountForm.clickSaveBtn();
	}
	
	@Test
	public void editAccountViewTest(){
		accountForm = accountView.clickEditLnk();
		accountForm.setViewName(accountEditedViewName).setViewUniqueName(accountEditedViewUniqueName);
		accountView = accountForm.clickSaveBtn();
		Assert.assertTrue(accountView.isViewDisplayed(), "Account View Edited");	
		 
	}
	
	@AfterMethod
	public void deleteAccountView() {
		accountView.deleteView();
		
	}	

}
