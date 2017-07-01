package org.fundacionjala.sfdc.framework.selenium.browser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * Class to manage the drivers.
 */
public final class DriverManager {

    private static final Environment ENVIRONMENT = Environment.getInstance();

    private static DriverManager instance;

    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * This method is in charge to initialize the DriverManager.
     */
    private DriverManager() {
        final Browser browser = Browser.valueOf(ENVIRONMENT.getBrowser().toUpperCase());
        driver = DriverFactory.getDriver(browser).initDriver();

        driver.manage().timeouts().implicitlyWait(ENVIRONMENT.getTimeout(), TimeUnit.SECONDS);
        driver.get(ENVIRONMENT.getBaseUrl());
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, ENVIRONMENT.getTimeout());
    }

    /**
     * This method Instance the instance if this does not exist.
     *
     * @return a instance.
     */
    public static DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    /**
     * Get the webDriver specification.
     *
     * @return webDriver Specification.
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Get the webDriver specification.
     *
     * @return webDriver Specification.
     */
    public WebDriverWait getWait() {
        return wait;
    }
}
