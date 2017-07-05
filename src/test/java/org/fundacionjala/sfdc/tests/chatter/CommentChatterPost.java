package org.fundacionjala.sfdc.tests.chatter;

import org.fundacionjala.sfdc.framework.selenium.Navigator;
import org.fundacionjala.sfdc.pages.LoginPage;
import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        LoginPage.loginAsPrimaryUser();
        ChatterAbstractPage chatterHome = Navigator.goToChatter();
        PostForm postForm = chatterHome.clickPostLnk();
        postForm.setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    /**
     * Method that verify the comments in the post.
     */
    @Test
    public void commentChatterPostTest() {
        PostForm commentForm = postContainer.clickCommentLkn(POST_CONTAIN);
        commentForm.setCommentTxt(TEST_COMMENT, POST_CONTAIN);
        PostContainer comment = commentForm.clickCommentBtn(POST_CONTAIN);
        Assert.assertTrue(comment.isPostDisplayed(POST_CONTAIN), "Chatter Comment Displayed");
    }

    /**
     * Method that delete the post.
     */
    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(POST_CONTAIN);
    }

}
