package org.fundacionjala.sfdc.pages.chatter;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class to represent the Chatter options.
 */
public class ChatterAbstractPage extends AbstractBasePage {

    @FindBy(xpath = "//a[@data-tab-name='FeedItem.TextPost']")
    @CacheLookup
    private WebElement textArea;

    /**
     * Method tha click on post link.
     *
     * @return {@link PostForm}
     */
    public PostForm clickPostLnk() {
        CommonActions.clickElement(textArea);
        return new PostForm();
    }
}
