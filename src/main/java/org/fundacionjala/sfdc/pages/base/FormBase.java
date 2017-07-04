package org.fundacionjala.sfdc.pages.base;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;

/**
 * This class contains the common procedures to manage Add, and Delete elements from different components:
 * Leads, Campaign, Account, Contact, ContractFields, Products.
 */
public abstract class FormBase extends AbstractBasePage {

    @FindBy(css = "button[title='Save']")
    protected WebElement saveButton;

    @FindBy(css = "button[title='Save & New']")
    protected WebElement saveNewBtn;

    @FindBy(css = "button[title='Cancel']")
    private WebElement cancelBtn;

    @FindBy(css = "div.visible.positioned li.uiMenuItem.uiRadioMenuItem>a")
    protected List<WebElement> generalDropdown;

    @FindBy(css = ".lookup__list.visible li.forceSearchInputLookupDesktopOption>a")
    protected List<WebElement> generalAcountDropdown;


    /**
     * Clicks on "save" button.
     *
     * @return {@link DetailBase}
     */
    public abstract AbstractBasePage clickSaveButton();

    /**
     * Clicks on "Save&New" button.
     *
     * @return {@link FormBase}
     */
    public abstract AbstractBasePage clickSaveNewButton();

    /**
     * Clicks on "Cancel" button.
     */
    public void clickCancelButton() {
        CommonActions.clickElement(cancelBtn);
    }
}
