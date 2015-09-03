package Scripts;

/**
 * Created by Ronald on 23/06/2015.
 */


import Framework.Objects.Lead;
import Pages.Leads.LeadDetailsPage;
import Pages.Leads.LeadHomePage;
import Pages.Leads.NewLeadPage;
import Pages.LoginPage;
import Pages.MainApp;
import Pages.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class CreateLead {
    private LeadHomePage leadHomePage;
    private NewLeadPage newLeadPage;
    private MainApp mainApp;
    private TabBar tabBar;
    private LoginPage loginPage;

    @BeforeTest
    public void setUp() throws Exception {
        loginPage = new LoginPage();
        mainApp = loginPage.loginAsPrimaryUser();
        tabBar = mainApp.goToTabBar();
        leadHomePage = tabBar.clickLead();

    }

    @Test
    public void createLeadTest() throws Exception {

        newLeadPage = leadHomePage.clickNewBtn();
        newLeadPage.fillNewLead();
        Lead leadLoaded = newLeadPage.getLoadedLead();

        LeadDetailsPage leadDetailsPage = newLeadPage.clickSaveButton();

        Assert.assertEquals(leadLoaded.nameSalutation + " " + leadLoaded.firstName + " " + leadLoaded.lastName, leadDetailsPage.getName() );

    }

    @AfterTest
    public void tearDown() throws Exception {

    }
}


