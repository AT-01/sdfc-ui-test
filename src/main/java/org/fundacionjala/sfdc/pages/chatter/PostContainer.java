package org.fundacionjala.sfdc.pages.chatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;


/**
 * Class to represent the post container.
 */
public class PostContainer extends AbstractBasePage {

    private static final int EXPECTATION_TIME_OUT = 15;
    private static final int SLEEP_IN_MILLISECONDS = 100;
    private static final int TIME_IN_MILLISECONDS = 1000;


    @FindBy(css = "a[title='Delete']")
    @CacheLookup
    private WebElement deleteOptn;

    @FindBy(xpath = "//a[@class='cuf-feedItemActionTrigger cuf-buttonIcon "
            + "slds-button--icon-border slds-button slds-button--icon-x-small']")
    @CacheLookup
    private WebElement downDropButton;

    @FindBy(xpath = "//a[@title='Edit']")
    @CacheLookup
    private WebElement editOptn;

    @FindBy(css = "slds-icon slds-icon-text-default slds-icon--xx-small slds-icon")
    @CacheLookup
    private WebElement settingsChatter;

    @FindBy(css = "a[title=Comment]")
    @CacheLookup
    private WebElement commentButton;

    @FindBy(xpath = "//span[text()='Comment']")
    @CacheLookup
    private WebElement confirmCommentButton;

    @FindBy(css = "button[title='Delete']")
    @CacheLookup
    private WebElement clickConfirmDelete;

    /**
     * Deletes a determined post.
     *
     * @param postTxt Is the post text used to identify the
     *                publication to be deleted.
     * @return Class Post Form.
     */
    public PostForm deletePost(final String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(deleteOptn);
        CommonActions.clickElement(clickConfirmDelete);
        return new PostForm();
    }

    /**
     * Deletes a determined post.
     */
    public void clickDownDropButton() {
        CommonActions.clickElement(downDropButton);
    }

    /**
     * Edits a determined post.
     *
     * @param postTxt Is the post text used to identify the
     *                publication to be edited.
     * @return {@link PostForm}
     */
    public PostForm editPost(final String postTxt) {
        clickActionMenu(postTxt);
        CommonActions.clickElement(editOptn);
        return new PostForm();

    }

    /**
     * Makes click on the action menu of a determined post.
     *
     * @param postText Is the post text used to identify the
     *                 publication to click its action menu.
     */
    private void clickActionMenu(final String postText) {
        WebElement actionMenu = driver.findElement(By.xpath("//span[text()='"
                + postText + "']/ancestor::"
                + " div[@class='cuf-feedElementIterationItem slds-feed__item']/descendant::"
                + " a[contains(@class, 'cuf-feedItemActionTrigger')]"));
        CommonActions.clickElement(actionMenu);
    }

    /**
     *
     * @param postxt .
     * @return <code>true</code>
     */
    public boolean isPostDisplayed(final String postxt) {
        WebElement postContainer = (driver.findElement(By.xpath("//span[contains(.,'" + postxt + "')]")));
        return CommonActions.isElementPresent(postContainer);
    }

    /**
     * Click on settings button.
     */
    public void clickSettingsChatter() {
        CommonActions.clickElement(settingsChatter);
    }

    /**
     * .click on commentButton.
     *
     * @return PostForm
     */
    public PostForm clickCommentButton() {
        CommonActions.clickElement(commentButton);
        return new PostForm();
    }

    /**
     * click on confirm comment button.
     */
    public void confirmComment() {
        CommonActions.clickElement(confirmCommentButton);
    }
}
