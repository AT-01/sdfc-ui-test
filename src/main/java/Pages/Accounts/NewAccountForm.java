package Pages.Accounts;


import Framework.CommonActions;
import Pages.Base.ViewFormBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;



/**
 * Created by ivan on 30-06-15.
 */
public class NewAccountForm extends ViewFormBase{


    //region Locators
    @FindBy(id = "acc2")
    @CacheLookup
    private WebElement accountNameTextbox;

    public NewAccountForm() {
        super();
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

    public AccountView clickSaveBtn() {
    	AccountView accountView = (AccountView) new AccountView().setViewName(this.viewNameTxt).setViewUniqueName(this.viewUniqueNameTxt);
    	CommonActions.click(saveBtn);
    	return accountView;
    }

}
