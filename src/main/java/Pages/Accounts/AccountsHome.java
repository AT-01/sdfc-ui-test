package Pages.Accounts;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Base.HomeBase;
import Pages.Opportunities.OpportunityProfile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class AccountsHome extends HomeBase{

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    public AccountsHome() {
        super();
    }

    public NewAccountForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewAccountForm();
    }
    public void clickOnAccount(String accountName)
    {
        driver.findElement(By.xpath("//span[contains(.,'" + accountName + "')]")).click();
    }



}
