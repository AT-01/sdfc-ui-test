package Pages.Campaigns;

import Framework.CommonActions;
import Pages.Base.HomeBase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CampaignsHome extends HomeBase{
    

    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    private WebElement NewButtton;
    //endregion
    
    public CampaignsHome()
    {
        super();
    }

    public NewCampaignForm clickNewButton() {
        CommonActions.click(NewButtton);
        return new NewCampaignForm();
    }

    public CampaignProfile goCampaingProfile(String url) {
        driver.navigate().to(url);
        return new CampaignProfile();
    }

	
	public NewCampaignForm clickNewViewLnk() {
		CommonActions.click(createNewViewLnk);
		return new NewCampaignForm();
	}

     
}
