package org.fundacionjala.sfdc.framework.selenium.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class initialize the Chrome Selenium Web Driver.
 */
public class Firefox implements Driver {

    private static final String WEB_DRIVER_PATH = "webdrivers/geckodriver.exe";

    private static final String WEB_DRIVER_KEY = "webdriver.gecko.driver";

    /**
     * {@inheritDoc}
     */
    @Override

    public WebDriver initDriver() {
        System.setProperty(WEB_DRIVER_KEY, WEB_DRIVER_PATH);
        return new FirefoxDriver();
    }
}
