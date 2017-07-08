package org.fundacionjala.sfdc.tests.chatter;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.AppLauncher;
import org.fundacionjala.sfdc.pages.MainApp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import static org.testng.Assert.assertTrue;

/**
 * Class to verify the comments chatter post.
 */
public class CommentChatterPost {

    private static final String TEST_COMMENT = "TestComment";
    private static final String POST_CONTAIN = "TestCommentPost";
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        MainApp mainApp = new MainApp();
        AppLauncher appLauncher = mainApp.clickAppLauncher();

        ChatterAbstractPage chatterHome = appLauncher.clickOnChatterTab();
        PostForm postForm = chatterHome.clickPostLnk();
        postForm.setPostTxt(POST_CONTAIN);
        postForm.clickShareBtn();
    }

    /**
     * Method that verify the comments in the post.
     */
    @Test
    public void commentChatterPostTest() {
        postContainer = new PostContainer();
        PostForm commentForm = postContainer.clickCommentButton();
        commentForm.setCommentTxt(TEST_COMMENT, POST_CONTAIN);
        postContainer.confirmComment();
        assertTrue(postContainer.isPostDisplayed(POST_CONTAIN), "TestCommentPost");
    }

    /**
     * Method that delete the post.
     */
    @AfterMethod
    public void deleteChatterPost() {
        CommonActions.sleep(5000);
        postContainer.deletePost(POST_CONTAIN);
    }

}
