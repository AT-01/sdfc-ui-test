package org.fundacionjala.sfdc.pages.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to represent the displayed buttons in the home pages.
 */
public abstract class HomeBase extends AbstractBasePage {

    @FindBy(css = ".active.oneContent a[title='New']")
    protected WebElement newButton;

    @FindBy(css = ".slds-icon-waffle")
    @CacheLookup
    protected WebElement iconWaffle;

    @FindBy(css = "button[title='List View Controls'")
    protected WebElement listViewButton;

    @FindBy(xpath = "//span[text()='New']")
    @CacheLookup
    protected WebElement createNewViewLink;

    @FindBy(css = "button[title='Edit List']")
    @CacheLookup
    protected WebElement editViewLink;

    /**
     * Clicks on "New" button.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickNewButton();

    /**
     * Clicks on "Create New View" link.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickCreateNewViewLink();

    /**
     * Clicks on "Edit" link.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickEditViewLink();
}
