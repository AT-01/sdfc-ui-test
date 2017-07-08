package org.fundacionjala.sfdc.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.sfdc.framework.selenium.browser.DriverManager;
import org.fundacionjala.sfdc.framework.selenium.CommonActions;
import org.fundacionjala.sfdc.framework.utils.Environment;
import org.fundacionjala.sfdc.pages.base.AbstractBasePage;

/**
 * Class to manage the login process.
 */
public class LoginPage extends AbstractBasePage {
    private static final int DURATION = 3;

    private static final DriverManager DRIVER_MANAGER = DriverManager.getInstance();

    private static final Environment ENVIRONMENT = Environment.getInstance();

    @FindBy(id = "username")
    @CacheLookup
    private static WebElement userNameField;

    @FindBy(id = "password")
    @CacheLookup
    private static WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    private WebElement loginField;

    /**
     * This method set the username in the text field.
     *
     * @param email String with the username or email.
     * @return {@link LoginPage}
     */
    private LoginPage setUserNameField(final String email) {
        CommonActions.sendKeys(userNameField, email);
        return this;
    }

    /**
     * This method set the password in the text field.
     *
     * @param password String  whit the password.
     * @return {@link LoginPage}
     */
    private LoginPage setPasswordField(final String password) {
        CommonActions.sendKeys(passwordTxt, password);
        return this;
    }

    /**
     * Method to click on button to logging the application..
     *
     * @return The home page.
     */
    private MainApp clickLogInToSalesforceButton() {
        loginField.click();
        return new MainApp();
    }

    /**
     * Method used to perform a login to Salesforce application.
     *
     * @param username Username used to perform a login to Salesforce application.
     * @param password Password used to perform a login to Salesforce application.
     * @return The main page after login to Salesforce application.
     */
    public MainApp loginAs(final String username, final String password) {
        return setUserNameField(username).setPasswordField(password).clickLogInToSalesforceButton();
    }

    /**
     * Method to perform a login with other user.
     *
     * @param userName Username to perform a login with other user.
     * @param password Password to perform a login with other user.
     * @param name First and Last Name displayed in page
     * @return The login to Mach2 application.
     */
    public MainApp loginOtherUser(String userName, final String password,
                                  final String name) {
        MainApp homePage;
        try {
            DRIVER_MANAGER.getDriver().manage().timeouts().implicitlyWait(DURATION, TimeUnit.SECONDS);
            DRIVER_MANAGER.getWait().withTimeout(DURATION, TimeUnit.SECONDS);
            homePage = new MainApp();
            if (!homePage.getUserLogged().equals(name)) {
                homePage.clickLogout();
                homePage = loginAs(userName, password);
            }
        } catch (WebDriverException e) {
            DRIVER_MANAGER.getDriver().get(ENVIRONMENT.getBaseUrl());
            homePage = loginAs(userName, password);
        } finally {
            DRIVER_MANAGER.getDriver().manage().timeouts().implicitlyWait(ENVIRONMENT.getTimeout(), TimeUnit.SECONDS);
            DRIVER_MANAGER.getWait().withTimeout(ENVIRONMENT.getTimeout(), TimeUnit.SECONDS);
        }
        return homePage;
    }

    /**
     * Method to perform a login as Primary user.
     *
     * @return Main page after login to Salesforce application.
     */
    public static MainApp loginAsPrimaryUser() {
        LoginPage loginPage = new LoginPage();
        return loginPage.loginOtherUser(ENVIRONMENT.getPrimaryUser(),
                ENVIRONMENT.getPrimaryPassword(),
            ENVIRONMENT.getFirstLastName());
    }

}
