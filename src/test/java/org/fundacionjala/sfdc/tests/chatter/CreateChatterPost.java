package org.fundacionjala.sfdc.tests.chatter;


import org.fundacionjala.sfdc.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.fundacionjala.sfdc.pages.chatter.ChatterAbstractPage;
import org.fundacionjala.sfdc.pages.chatter.PostContainer;
import org.fundacionjala.sfdc.pages.chatter.PostForm;
import org.fundacionjala.sfdc.framework.selenium.Navigator;

/**
 * Method that verify the creation of chatter.
 */
public class CreateChatterPost {

    private static final String POST_CONTAIN = "TestCreatePost";
    private ChatterAbstractPage chatterHome;
    private PostContainer postContainer;


    /**
     * Before method.
     */
    @BeforeMethod
    public void setUp() {
        LoginPage.loginAsPrimaryUser();
        chatterHome = Navigator.goToChatter();
    }

    /**
     * Method that verify the creation of chatter post.
     */
    @Test
    public void createChatterPostTest() {
        PostForm postForm = chatterHome.clickPostLnk().setPostTxt(POST_CONTAIN);
        postContainer = postForm.clickShareBtn();
        Assert.assertTrue(postContainer.isPostDisplayed(), "Chatter Post Displayed");
    }

    /**
     * Method that delete the created post.
     */
    @AfterMethod
    public void deleteChatterPost() {
        postContainer.deletePost(POST_CONTAIN);
    }

}
