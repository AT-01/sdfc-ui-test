package Pages.Opportunities;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Base.HomeBase;
import Pages.Base.ViewFormBase;
import Pages.Campaigns.CampaignProfile;
import Pages.Campaigns.NewCampaignForm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 26-06-15.
 */
public class OpportunitiesHome extends HomeBase{
    
    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    public OpportunitiesHome() {
        super();
    }

    public NewOpportunityForm clickNewButton() {
        CommonActions.click(NewButtton);

        return new NewOpportunityForm();
    }

    public OpportunityProfile goOpportunityProfile(String url) {
        driver.navigate().to(url);

        return new OpportunityProfile();
    }

    public NewOpportunityForm clickNewViewLnk() {
		CommonActions.click(createNewViewLnk);
		return new NewOpportunityForm();
	}

}
