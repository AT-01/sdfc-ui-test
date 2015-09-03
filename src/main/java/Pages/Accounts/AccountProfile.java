package Pages.Accounts;

import Framework.BrowserManager;
import Pages.MainApp;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 30-06-15.
 */
public class AccountProfile {

    private WebDriver driver;
    private WebDriverWait wait;

    // private Flag
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    @FindBy(xpath = "//input[@name='delete']")
    @CacheLookup
    private WebElement deleteButton;

    public AccountProfile() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public MainApp deleteAccount() {
        deleteButton.click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        return new MainApp();
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }
}
