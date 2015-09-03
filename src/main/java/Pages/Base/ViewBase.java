package Pages.Base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.BrowserManager;
import Framework.CommonActions;

public abstract class ViewBase {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected String viewName;
	protected String viewUniqueName;
    
	@FindBy(name = "fcf")
    @CacheLookup
    protected WebElement viewsDropdown;
	
	@FindBy(linkText = "Delete")
    @CacheLookup
    protected WebElement deleteLnk;
	
	@FindBy(linkText = "Edit")
    @CacheLookup
    protected WebElement editLnk;
	
	public ViewBase() {
		driver = BrowserManager.getInstance().getDriver();
		wait = BrowserManager.getInstance().getWait();
		PageFactory.initElements(driver, this);
	}

	public ViewBase setViewName(String viewNameTxt) {
		this.viewName = viewNameTxt;
		return this;
	}
	
	public ViewBase setViewUniqueName(String viewUniqueNameTxt) {
		this.viewUniqueName = viewUniqueNameTxt;
		return this;
	}
	
	public boolean isViewDisplayed() {
		CommonActions.click(viewsDropdown);
		WebElement viewOption;
		try {	
			
			viewOption = driver.findElement(By.xpath("//option[contains(.,'"+getViewName()+"')]"));	
			
		} catch(WebDriverException e) {
			return false;
		}	
		return isElementPresent(viewOption);
	}
	
	public boolean isElementPresent(WebElement webElement) {
        try {
            webElement.getText();
            return true;
        } catch (WebDriverException e) {
            return false;
        }
    }
	
	public String getViewName() {
		return viewName;
		
	}
	
	public String getViewUniqueName() {
		return viewUniqueName;
		
	}
	
	public void deleteView() {
		CommonActions.click(deleteLnk);	
		Alert alert = driver.switchTo().alert();
		alert.accept();		
	}
}
