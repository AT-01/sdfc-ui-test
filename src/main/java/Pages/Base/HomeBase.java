package Pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Contacts.NewContactForm;
import Pages.Leads.NewLeadForm;


public abstract class HomeBase {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@FindBy(linkText = "Create New View")
    @CacheLookup
    protected WebElement createNewViewLnk;
    
	public HomeBase() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public abstract ViewFormBase clickNewViewLnk ();

}
