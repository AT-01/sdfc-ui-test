package Pages.Accounts;

import Framework.BrowserManager;
import Framework.CommonActions;

import Pages.LookUp.LookUpWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Victor Paredes on 6/25/2015.
 */
public class NewAccountForm {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "acc2")
    //@CacheLookup
    private WebElement accountNameField1;

    @FindBy(id = "acc3_lkwgt")
    @CacheLookup
    WebElement parentAccountLookUpIcon;

    @FindBy(id = "acc3")
    @CacheLookup
    private WebElement parentAccountField;


    @FindBy(id = "acc5")
    @CacheLookup
    private WebElement accountNumberField;

    @FindBy(id = "acc23")
    @CacheLookup
    private WebElement accountSiteField;

    @FindBy(id = "acc6")
    @CacheLookup
    private WebElement typeDropdownField;

    @FindBy(id = "acc7")
    @CacheLookup
    private WebElement industryDropdownField;

    @FindBy(id = "acc8")
    @CacheLookup
    private WebElement annualRevenueField;

    @FindBy(id = "acc9")
    @CacheLookup
    private WebElement ratingDropdownField;

    @FindBy(id = "acc10")
    @CacheLookup
    private WebElement phoneField;

    @FindBy(id = "acc11")
    @CacheLookup
    private WebElement faxField;

    @FindBy(id = "acc12")
    @CacheLookup
    private WebElement websiteField;

    @FindBy(id = "acc13")
    @CacheLookup
    private WebElement tickerSymbolField;

    @FindBy(id = "acc14")
    @CacheLookup
    private WebElement ownerDropdownField;

    @FindBy(id = "acc15")
    @CacheLookup
    private WebElement employeesField;

    @FindBy(id = "acc16")
    @CacheLookup
    private WebElement sicCodeField;

    @FindBy(xpath = "//*[@name='save']")
    @CacheLookup
    private WebElement saveButton;

/*    @FindBy(id = "")
    @CacheLookup
    WebElement Field;*/

    public NewAccountForm(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);
    }

    public NewAccountForm setAccountNameField(String accountName) {

        accountNameField1.clear();
        accountNameField1.sendKeys(accountName);
//        CommonActions.setValue(accountNameField, accountName);
        return this;
    }

    public NewAccountForm setAccountNumberField(String text) {
        CommonActions.setValue(accountNumberField, text);
        return this;
    }

    public NewAccountForm setAccountSiteField(String text) {
        CommonActions.setValue(accountSiteField, text);
        return this;
    }

    public NewAccountForm selectTypeDropdown(String item) {
        CommonActions.selectItem(typeDropdownField, item);
        return this;
    }

    public NewAccountForm selectIndustryDropdown(String item) {
        CommonActions.selectItem(industryDropdownField, item);
        return this;
    }

    public NewAccountForm setAnnualRevenueField(String text) {
        CommonActions.setValue(annualRevenueField, text);
        return this;
    }

    public NewAccountForm selectRatingDropdown(String item) {
        CommonActions.selectItem(ratingDropdownField, item);
        return this;
    }

    public NewAccountForm setPhoneField(String text) {
        CommonActions.setValue(phoneField, text);
        return this;
    }

    public NewAccountForm setFaxField(String text) {
        CommonActions.setValue(faxField, text);
        return this;
    }

    public NewAccountForm setWebsiteField(String text) {
        CommonActions.setValue(websiteField, text);
        return this;
    }

    public NewAccountForm setTickerSymbolField(String text) {
        CommonActions.setValue(tickerSymbolField, text);
        return this;
    }

    public NewAccountForm selectOwnershipDropdown(String item) {
        CommonActions.selectItem(ownerDropdownField, item);
        return this;
    }

    public NewAccountForm setEmployeesField(String text) {
        CommonActions.setValue(employeesField, text);
        return this;
    }

    public NewAccountForm setSicCodeField(String text) {
        CommonActions.setValue(sicCodeField, text);
        return this;
    }

/*    public NewAccountForm setField(String text) {
        CommonActions.setValue(, text);
        return this;
    }*/

    public AccountProfile clickSaveButton() {
        CommonActions.click(saveButton);
        return new AccountProfile(driver);
    }

    public LookUpWindow clickLookUpIcon() {
        CommonActions.click(parentAccountLookUpIcon);
        return new LookUpWindow(driver);
    }

    public NewAccountForm setParentAccountField(String parentAccountName) {
        CommonActions.setValue(parentAccountField, parentAccountName);
        return this;
    }
}
