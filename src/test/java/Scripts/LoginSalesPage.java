package Scripts;

import org.testng.annotations.BeforeTest;
import Pages.LoginPage;
import Pages.MainApp;

public class LoginSalesPage {

    private MainApp mainApp;  
    private LoginPage loginPage;
    
    @BeforeTest
	public void login() {
    	
    	loginPage = new LoginPage();
    	mainApp = loginPage.loginAsPrimaryUser();                     
	}
}
