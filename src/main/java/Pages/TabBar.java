package Pages;

import Pages.Accounts.AccountsHome;
import Pages.Chatter.ChatterHome;
import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.CampaignsHome;
import Pages.Contacts.ContactsHome;
import Pages.Leads.LeadHome;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Products.ProductsHome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/17/2015.
 */
public class TabBar {
    private WebDriver driver;
    private WebDriverWait wait;

    //region Locators

    @FindBy(linkText = "Campaigns")
    @CacheLookup
    WebElement CampaignsTab;

    @FindBy(xpath = "//*[@id='Opportunity_Tab']/*[contains(.,'Opportunities')]")
    @CacheLookup
    WebElement opportunitiesTab;

    @FindBy(xpath = "//*[@id='Product2_Tab']/*[contains(.,'Products')]")
    @CacheLookup
    WebElement productsTab;

    @FindBy(linkText = "Accounts")
    @CacheLookup
    WebElement accountTab;
	
    @FindBy(linkText = "Leads")
    @CacheLookup
    WebElement LeadTab;

    @FindBy(xpath = "//a[@href='/003/o']")
    @CacheLookup
    WebElement contactsTab;
    //endregion

    @FindBy(linkText = "Chatter")
    @CacheLookup
    private WebElement chatterTab;

    public TabBar()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public CampaignsHome clickCampaigns() {
        CommonActions.click(CampaignsTab);
        return new CampaignsHome();
    }

    public ContactsHome clickContacts() {
        CommonActions.click(contactsTab);
        return new ContactsHome(driver);
    }

    public OpportunitiesHome clickOpportunityTab() {
        CommonActions.click(opportunitiesTab);

        return new OpportunitiesHome();
    }

    public ProductsHome clickProductsTab() {
        CommonActions.click(productsTab);

        return new ProductsHome(driver);
    }

    public AccountsHome clickAccountsTab() {
        CommonActions.click(accountTab);
        return new AccountsHome();
    }
	
	public LeadHome clickLeadTab() {
        CommonActions.click(LeadTab);
        return new LeadHome();
    }

	public ChatterHome clickOnChatterTab() {
		CommonActions.click(chatterTab);
		return new ChatterHome();
	}
}
