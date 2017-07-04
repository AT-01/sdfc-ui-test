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
 * Class to Edit Chatter post.
 */
public class EditChatterPost {

    private static final String POST_CONTAIN = "TestEditPost";
    private static final String NEW_POST_CONTAIN = "TestPost123";
    private PostForm postForm;
    private PostContainer postContainer;

    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        LoginPage.loginAsPrimaryUser();
        ChatterAbstractPage chatterHome = Navigator.goToChatter();
        postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
    }

    /**
     * Test to verify the Edition of chatter post.
     */
    @Test
    public void editChatterPostTest() {
        postForm = postContainer.editPost(POST_CONTAIN);
        postForm.editPostTxt(NEW_POST_CONTAIN);
        postContainer = postForm.clickSaveBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(POST_CONTAIN), "Chatter Post Displayed");
    }

    /**
     * Method to delete the created post in the precondition.
     */
    @AfterMethod
    public void deleteChatterPost() {

        postContainer.deletePost(NEW_POST_CONTAIN);
    }

}
