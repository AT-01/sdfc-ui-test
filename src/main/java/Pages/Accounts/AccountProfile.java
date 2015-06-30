package Pages.Accounts;


import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.CampaignsHome;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Victor Paredes on 6/26/2015.
 */
public class AccountProfile {

    WebDriver Driver;
    WebDriverWait wait;

    @FindBy(className = "topName")
    @CacheLookup
    WebElement AccountNameLabel;

    @FindBy(name = "delete")
    @CacheLookup
    WebElement deleteButton;


    public AccountProfile(WebDriver driver)
    {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public String getAccountNameLabel() {
        return AccountNameLabel.getText();
    }

    public String getUrl()
    {
        return Driver.getCurrentUrl();
    }

    public AccountsHome clickDeleteButton() {
        CommonActions.click(deleteButton);
        Alert alert = Driver.switchTo().alert();
        alert.accept();
        Driver.switchTo().defaultContent();
        return new AccountsHome(Driver);
    }
}
