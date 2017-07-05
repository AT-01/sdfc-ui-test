package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


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

    @FindBy(css = "div[class='uiMenu forceChatterOverflowActionMenu']")
    @CacheLookup
    private WebElement downDropButton;

    @FindBy(xpath = "//a[@title='Edit']")
    @CacheLookup
    private WebElement editOptn;

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
        WebElement actionMenu = driver.findElement(By.xpath("//span[text()='" + postText + " " + "']/ancestor::"
                + "div[@class='cuf-feedElementIterationItem slds-feed__item']/descendant::"
                + "a[contains(@class, 'cuf-feedItemActionTrigger')]"));
        CommonActions.clickElement(actionMenu);
    }

    /**
     * Method that verify os an element is present.
     * @param postText text value.
     * @return true if the element is present.
     */
    public boolean isPostDisplayed(String postText) {
        WebElement postContainer = driver.findElement(By.xpath("//span[contains(.,'" + postText + "')]"));
        return CommonActions.isElementPresent(postContainer);
    }

    /**
     * Method that makes click on comment link.
     *
     * @param postTxt String with the Post.
     * @return {@link PostForm}
     */
    public PostForm clickCommentLkn(final String postTxt) {
        WebElement postContainer = driver.findElement(By.xpath("//span[contains(.,'"
                + postTxt + "')]/following::a[text()='Comment']"));
        CommonActions.clickElement(postContainer);
        return new PostForm();

    }
}
