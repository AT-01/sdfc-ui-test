package org.fundacionjala.sfdc.pages.chatter;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class that represents the form where to introduce the text on chatter.
 */
public class PostForm extends AbstractBasePage {

    private static final int TIME_IN_MILLISECONDS = 3000;

    @FindBy(xpath = "//button[@class='slds-button slds-button--neutral "
            +
            "cuf-publisherShareButton qe-textPostDesktop MEDIUM uiButton--default uiButton--brand uiButton']")
    @CacheLookup
    private WebElement shareBtn;

    @FindBy(name = "quickActionSubmitButton")
    @CacheLookup
    private WebElement saveBtn;

    @FindBy(css = "body[class='chatterPublisherRTE cke_editable "
            + "cke_editable_themed cke_contents_ltr cke_show_borders'] ")
    @CacheLookup
    private WebElement editTxtArea;

    @FindBy(xpath = "//span[text()='Share an update...']/parent::button")
    @CacheLookup
    private WebElement clickTextArea;


    @FindBy(css = "div[data-placeholder='Share an update, @mention someone, add a file...']")
    @CacheLookup
    private WebElement textAreaField;

    @FindBy(xpath = "//a[@class='cuf-feedItemActionTrigger "
            + "cuf-buttonIcon slds-button slds-button--icon-border slds-button--icon-x-small']")
    @CacheLookup
    private WebElement clickButtonAction;




    /**
     * Edits the text of the post publication.
     *
     * @param postText Is the text that is going to be
     *                 written in the post text field.
     * @return {@link PostForm}
     */
    public PostForm setPostTxt(final String postText) {
        clickTextArea();
        CommonActions.sendKeys(textAreaField, postText);
        return this;
    }

    /**
     * Edits the text of the post publication.
     */
    public void clickTextArea() {
        clickTextArea.click();
    }


    /**
     * Edits the text of a comment from a publication.
     *
     * @param commentText Is the text that is going to be
     *                    written in the comment text field.
     * @param postText    Is the post to fin to write the comment.
     * @return {@link PostForm}
     */
    public PostForm setCommentTxt(final String commentText, final String postText) {
        WebElement commentTxt = driver.findElement(By.xpath("//span[contains(.,'"
                + postText + "')]/following::textarea[contains(@class,"
                + "'foobar cxnewcommenttext groupAtMentionsEnabled')]"));
        CommonActions.sendKeys(commentTxt, commentText);
        return this;
    }

    /**
     * Edits the text of the post already published.
     * The edit post happens too fast that's why it put a sleep of 3 seconds.
     *
     * @param postTxt Is the text that is going to be
     *                written in the post text field.
     * @return {@link PostForm}
     */
    public PostForm editPostTxt(final String postTxt) {
        try {
            Thread.sleep(TIME_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(driver
                .findElement(By.xpath("//iframe[contains(@title,'Rich Text Editor, quickActionRichTextEditor')]")));
        CommonActions.sendKeys(editTxtArea, postTxt);
        driver.switchTo().defaultContent();
        return this;
    }

    /**
     * Makes click on the Share button.
     *
     * @return {@link PostContainer}
     */
    public PostContainer clickShareBtn() {
        CommonActions.clickElement(shareBtn);
        return new PostContainer();
    }

    /**
     * Makes click on the save button.
     *
     * @return {@link PostContainer}
     */
    public PostContainer clickSaveBtn() {
        CommonActions.clickElement(saveBtn);
        return new PostContainer();
    }

    /**
     * Makes click on the comment button.
     * @param postText text data.
     * @return {@link PostContainer}
     */
    public PostContainer clickCommentBtn(String postText) {
        WebElement commentBtn = driver.findElement(
                By.xpath("//span[contains(.,'" + postText + "')]/following::input[@value = 'Comment']"));
        CommonActions.clickElement(commentBtn);
        return new PostContainer();
    }

}
