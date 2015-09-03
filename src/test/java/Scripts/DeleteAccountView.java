package Scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.MainApp;
import Pages.TabBar;
import Pages.Accounts.AccountView;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;

public class DeleteAccountView {
	
	private AccountsHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewAccountForm accountForm;
    private String accountViewName = "testAccountDelete";
    private String accountViewUniqueName = "testAccountUniqueDelete";
    private AccountView accountView;
    
    @BeforeMethod
	public void createAccountView() {
    	
    	mainApp = new MainApp(); 
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickAccountsTab();
        accountForm = (NewAccountForm) accountHome.clickNewViewLnk().setViewName(accountViewName).setViewUniqueName(accountViewUniqueName);
		accountView = accountForm.clickSaveBtn();
	}
	
	@Test
	public void deleteAccountViewTest(){
		accountView.deleteView();
		mainApp = new MainApp();
	    tabBar = mainApp.goToTabBar();
	    accountHome = tabBar.clickAccountsTab();
		Assert.assertFalse(accountView.isViewDisplayed(), "Account View Deleted");	
		 
	}


}
