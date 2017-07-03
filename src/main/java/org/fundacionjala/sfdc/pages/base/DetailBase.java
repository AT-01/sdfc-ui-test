package org.fundacionjala.sfdc.pages.base;

import java.util.Map;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AssertsDetails;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represents the details options.
 */
public abstract class DetailBase extends AbstractBasePage {

    @FindBy(css = "[title='Delete']")
    @CacheLookup
    protected WebElement deleteBtn;

    @FindBy(xpath = "//button[@title='Edit Status']")
    @CacheLookup
    protected WebElement editBtn;

    @FindBy(name = "clone")
    @CacheLookup
    protected WebElement cloneBtn;

    @FindBy(css = "[title='Details']")
    @CacheLookup
    protected WebElement detailsLinkButton;

    @FindBy(css = "button[title='Delete']")
    @CacheLookup
    protected WebElement confirmDeleteButton;

    @FindBy(css = ".uiMenu a[title='Show more actions for this record']")
    @CacheLookup
    protected WebElement downArrow;

    /**
     * Clicks on "edit" button.
     *
     * @return {@link AbstractBasePage}
     */
    public abstract AbstractBasePage clickEditButton();

    /**
     * Clicks on "delete" button.
     *
     * @return {@link AbstractBasePage}
     */
    public abstract AbstractBasePage clickDeleteButton();

    /**
     * Method that load the Strategy Map to make the assertions.
     *
     * @return the Map with the values to make assertions.
     */
    public abstract Map<String, AssertsDetails> getStrategyAssertMap();

    /**
     * Method allows to make a click on Details link.
     */
    public void clickDetailsLink() {
        CommonActions.sleep(2000);
        CommonActions.clickElement(detailsLinkButton);
    }

}
