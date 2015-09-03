package Scripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import Pages.Accounts.AccountView;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;


public class CreateAccountView {
	
	private AccountsHome accountHome;
    private MainApp mainApp;
    private TabBar tabBar;
    private NewAccountForm accountForm;
    private LoginPage loginPage;
    private String accountViewName = "testAccountView1";
    private String accountViewUniqueName = "testAccountUniqueView1";
    private AccountView accountView;
    
    @BeforeMethod
	public void login() {
    	
    	loginPage = new LoginPage();
    	mainApp = loginPage.loginAsPrimaryUser();  
        tabBar = mainApp.goToTabBar();
        accountHome = tabBar.clickAccountsTab();    
	}
	
	@Test
	public void createAccountViewTest(){
		
		accountForm = (NewAccountForm) accountHome.clickNewViewLnk().setViewName(accountViewName).setViewUniqueName(accountViewUniqueName);
		accountView = accountForm.clickSaveBtn();
		Assert.assertTrue(accountView.isViewDisplayed(), "Account View Displayed");	
		 
	}
	
	@AfterMethod
	public void deleteAccountView() {
		accountView.deleteView();
	}	

}
