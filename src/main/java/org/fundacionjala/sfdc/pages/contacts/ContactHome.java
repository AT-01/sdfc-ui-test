package org.fundacionjala.sfdc.pages.contacts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.common.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * This class represents to contact pages.
 */
public class ContactHome extends AbstractBasePage {

    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    private WebElement newButton;

    /**
     *
     * @return
     */
    public ContactForm clickPostLnk() {
        CommonActions.clickElement(newButton);
        return new ContactForm();
    }


}