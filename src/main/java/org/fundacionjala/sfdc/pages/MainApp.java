package org.fundacionjala.sfdc.pages;

import org.fundacionjala.sfdc.framework.utils.CommonActions;
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

    @FindBy(css = "#recentItems tr:first-child td a")
    private WebElement userInformationLink;

    @FindBy(linkText = "Logout")
    @CacheLookup
    private WebElement logoutBtn;


    /**
     * Method that makes click on logout link.
     */
    public void clickLogout() {
        CommonActions.clickElement(logoutBtn);
    }

    /**
     * Method that goes to the tab bar.
     *
     * @return {@link AppLauncher}
     */
    public AppLauncher clickAppLauncher() {
        CommonActions.sleep();
        CommonActions.clickElement(appLauncherButton);
        return new AppLauncher();
    }

    /**
     * Method that makes click on the user Information link.
     *
     * @return {@link UserInformationPage}
     */
    public UserInformationPage clickUserInformationLink() {
        CommonActions.clickElement(userInformationLink);
        return new UserInformationPage();
    }
}
