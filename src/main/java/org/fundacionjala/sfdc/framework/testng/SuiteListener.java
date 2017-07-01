package org.fundacionjala.sfdc.framework.testng;

import org.testng.ISuite;
import org.testng.ISuiteListener;

import org.fundacionjala.sfdc.framework.selenium.browser.DriverManager;
import org.fundacionjala.sfdc.pages.LoginPage;

/**
 * Class to manage the login and close the driver for each suite.
 */
public class SuiteListener implements ISuiteListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void onStart(final ISuite suite) {
        LoginPage.loginAsPrimaryUser();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onFinish(final ISuite suite) {
        DriverManager.getInstance().getDriver().quit();
    }
}
