package Scripts;

import Framework.BrowserManager;
import Pages.Accounts.AccountProfile;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by Victor Paredes on 6/25/2015.
 */
public class CreateAccount {

    private TabBar tabBar;
    private AccountsHome accountsHome;
    private LookUpWindow lookUpWindow;
    private NewAccountForm newAccountForm;
    private AccountProfile accountProfile;
    private String parentAccountName;
    private String parentAccountURL;

    @BeforeTest
    public void setUp(){

        String username = "victor_test@dev.com";
        String password = "vControl123p";

        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");

        tabBar = new LoginPage()
                .setUserNameField(username)
                .setPasswordField(password)
                .clickLogInToSalesforceButton();

        parentAccountName = "Account Parent" + new Random().nextInt(9999);
        accountsHome = tabBar
                .clickAccountsTab();

        newAccountForm = accountsHome
                .clickNewButton();

        accountProfile = newAccountForm
                .setAccountNameField(parentAccountName)
                .clickSaveButton();

        parentAccountURL = accountProfile.getUrl();


    }

    @Test
    public void verifyCreateAccount(){
        String accountName = "Account 123";
        String accountNumber = "0001";
        String accountSite = "Site 001";
        String accountType = "Prospect";
        String accountIndustry = "Banking";
        String annualRevenue = "540241";
        String accountRating = "Warm";
        String accountPhone = "56721345";
        String accountFax = "234645623";
        String accountWebsite = "account.com.gov.abc";
        String accountTickerSymbol = "S001";
        String accountOwnership = "Public";
        String accountEmployees = "57";
        String accountSicCode = "7832";


        accountsHome = tabBar
                .clickAccountsTab();

        newAccountForm = accountsHome
                .clickNewButton();



        boolean easyMode = true;

        if (easyMode){
            newAccountForm
                    .setAccountNameField(accountName)
                    .setAccountNumberField(accountNumber)
                    .setAccountSiteField(accountSite)
                    .selectTypeDropdown(accountType)
                    .selectIndustryDropdown(accountIndustry)
                    .setParentAccountField(parentAccountName);

        }
        else{
            lookUpWindow = newAccountForm
                    .setAccountNameField(accountName)
                    .setAccountNumberField(accountNumber)
                    .setAccountSiteField(accountSite)
                    .selectTypeDropdown(accountType)
                    .selectIndustryDropdown(accountIndustry)
                    .clickLookUpIcon();

            newAccountForm = lookUpWindow
                    .switchSearchFrame()
                    .setSearchWithinField(parentAccountName)
                    .clickGoButton()
                    .switchResultsFrame()
                    .clickAccountResult(parentAccountName);
        }

        accountProfile = newAccountForm
                .setAnnualRevenueField(annualRevenue)
                .selectRatingDropdown(accountRating)
                .setPhoneField(accountPhone)
                .setFaxField(accountFax)
                .setWebsiteField(accountWebsite)
                .setTickerSymbolField(accountTickerSymbol)
                .selectOwnershipDropdown(accountOwnership)
                .setEmployeesField(accountEmployees)
                .setSicCodeField(accountSicCode)
              .clickSaveButton();

        String expectedName = accountProfile.getAccountNameLabel();

        Assert.assertEquals(expectedName, accountName);

    }


    @AfterTest
    public void tearDown(){
        accountsHome = accountProfile
                .clickDeleteButton();

        accountProfile = accountsHome
                .goAccountProfile(parentAccountURL);

        accountsHome = accountProfile
                .clickDeleteButton();

    }



}
