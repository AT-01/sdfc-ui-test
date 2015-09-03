package Pages.Leads;


import Pages.Base.HomeBase;
import Pages.Campaigns.NewCampaignForm;
import Framework.CommonActions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LeadHome extends HomeBase{
 
    //region Locators

    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewLeadFormButtton;
    //endregion

    public LeadHome()
    {
        super();
    }

    public NewLeadForm clickNewButton() {
        CommonActions.click(NewLeadFormButtton);
        return new NewLeadForm();
    }
    
    public NewLeadForm clickNewViewLnk() {
    	CommonActions.click(createNewViewLnk);
    	return new NewLeadForm();
    } 
}