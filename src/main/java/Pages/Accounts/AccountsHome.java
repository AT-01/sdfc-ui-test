package Pages.Accounts;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Victor Paredes on 6/24/2015.
 */
public class AccountsHome {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement newButton;

    public AccountsHome(WebDriver driver)
    {
        this.driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public NewAccountForm clickNewButton() {
        CommonActions.click(newButton);
        return new NewAccountForm(driver);
    }


    public AccountProfile goAccountProfile(String url) {
        driver.navigate().to(url);
        return new AccountProfile(driver);
    }
}
