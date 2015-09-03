package Pages.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;
import Framework.CommonActions;

public abstract class ViewFormBase {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	@FindBy(id = "fname")
    @CacheLookup
    protected WebElement viewName;
    
    @FindBy(id = "devname")
    @CacheLookup
    protected WebElement viewUniqueName;
    

    @FindBy(name = "save")
    @CacheLookup
    protected WebElement saveBtn;
    
    protected String viewNameTxt;
    protected String viewUniqueNameTxt;
    
	public ViewFormBase() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}
	
	public abstract ViewBase clickSaveBtn();
		
	
	
	public ViewFormBase setViewName(String viewNameTxt) {
		this.viewNameTxt = viewNameTxt;
        CommonActions.setValue(viewName, viewNameTxt);
        return this;
    }
    
    public ViewFormBase setViewUniqueName(String viewUniqueNameTxt) {
    	this.viewUniqueNameTxt = viewUniqueNameTxt;
        CommonActions.setValue(viewUniqueName, viewUniqueNameTxt);
        return this;
    }
}
