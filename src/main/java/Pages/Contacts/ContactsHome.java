package Pages.Contacts;


import Framework.CommonActions;
import Pages.Base.HomeBase;

import Pages.Contacts.NewContactForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Gisela on 6/28/2015.
 */
public class ContactsHome extends HomeBase{
   
    //region Locators

    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    WebElement newButton;
    //endregion

    public ContactsHome(WebDriver driver)
    {
    	super();
    }

    public NewContactForm clickNewButton() {
        CommonActions.click(newButton);
        return new NewContactForm();
    }

    public NewContactForm clickNewViewLnk() {
		CommonActions.click(createNewViewLnk);
		return new NewContactForm();
	}

    
}
