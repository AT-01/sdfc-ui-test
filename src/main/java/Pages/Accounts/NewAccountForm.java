package Pages.Accounts;

import Framework.BrowserManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 30-06-15.
 */
public class NewAccountForm {

    private WebDriver       driver;
    private WebDriverWait   wait;

    //region Locators
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTextbox;

    @FindBy(name = "save")
    @CacheLookup
    private WebElement saveBtn;
    //endregion

    public NewAccountForm() {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public NewAccountForm setAccountName(String accountName) {
        accountNameTextbox.clear();
        accountNameTextbox.sendKeys(accountName);

        return this;
    }

    public AccountProfile pressSaveBtn() {
        saveBtn.click();

        return new AccountProfile();
    }
    public AccountProfile clickOnAccount(String accountName)
    {
        System.out.println("here 1");
        //driver.findElement(By.linkText(accountName)).click();
        /*return new AccountProfile();*/
        System.out.println("here 2");
        driver.findElement(By.xpath("//span[contains(.,'" + accountName + "')]")).click();
        return new AccountProfile();
        //driver.findElement(By.xpath("//span[contains(.,'"+accountName+"')]")).click();

    }


}
