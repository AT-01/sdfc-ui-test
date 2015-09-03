package Pages.Campaigns;


import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Miguel.Pari on 6/24/2015.
 */
public class CampaignProfile {

    private WebDriver driver;
    private WebDriverWait wait;

    //region Locators

    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement CampaingNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement DeleteButton;
    //endregion

    public CampaignProfile()
    {
        driver = BrowserManager.getInstance().getDriver();
        wait = BrowserManager.getInstance().getWait();
        PageFactory.initElements(driver, this);
    }

    public String getCampaingNameLabel() {
        return CampaingNameLabel.getText();
    }

    public CampaignsHome clickDeleteButton()
    {
        CommonActions.click(DeleteButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();
        return new CampaignsHome();
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

}
