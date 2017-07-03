package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Class to manage the main page.
 */
public class MainApp extends AbstractBasePage {

    @FindBy(css = ".slds-icon-waffle")
    @CacheLookup
    private WebElement appLauncherButton;

    @FindBy(css = ".profile-card-name a")
    private WebElement userInfo;

    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;

    @FindBy(css = ".profileTrigger")
    @CacheLookup
    private WebElement viewProfile;


    /**
     * Method that makes click on logout link.
     */
    public void clickLogout() {
        CommonActions.clickElement(viewProfile);
        CommonActions.clickElement(logoutBtn);
    }

    /**
     * Method that goes to the tab bar.
     *
     * @return {@link AppLauncher}
     */
    public AppLauncher clickAppLauncher() {
        CommonActions.sleep(15000);
        CommonActions.clickElement(appLauncherButton);
        return new AppLauncher();
    }


    /**
     * Method that makes click on the user Information link.
     *
     * @return {@link UserInformationPage}
     */
    public String getUserLooged() {
        String userLogged;
        try {
            CommonActions.clickElement(viewProfile);
            userLogged = String.valueOf(CommonActions.getText(userInfo));
        } catch (Exception e) {
            userLogged = e.toString();
        }
        return userLogged;
    }
}
