package org.fundacionjala.sfdc.pages.base;

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
