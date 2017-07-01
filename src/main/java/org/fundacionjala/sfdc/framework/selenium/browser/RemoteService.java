package org.fundacionjala.sfdc.framework.selenium.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.framework.utils.Environment;

/**
 * Abstract class that is in charge to run test on saucelab and browserstack.
 */
public abstract class RemoteService implements Driver {

    private static final Logger LOGGER = LogManager.getLogger(RemoteService.class);

    protected static final Environment ENVIRONMENT = Environment.getInstance();

    private static final String HTTPS_PROXY_HOST = "https.proxyHost";

    private static final String HTTPS_PROXY_PORT = "https.proxyPort";

    protected static final String RESOLUTION = "screenResolution";

    /**
     * Set the capabilities values for browser stack and sauce labs.
     *
     * @return DesiredCapabilities.
     */
    public abstract DesiredCapabilities setCapabilities();

    /**
     * Get the url required to run.
     *
     * @return String url.
     */
    public abstract String getUrl();

    /**
     * Initiate the connection.
     *
     * @return WebDriver.
     */
    public WebDriver initDriver() {
        final String url = String.format(getUrl(),
                ENVIRONMENT.getRemoteUserName(),
                ENVIRONMENT.getRemoteKey());
        if (!ENVIRONMENT.getProxy().isEmpty()) {
            System.getProperties().put(HTTPS_PROXY_HOST, ENVIRONMENT.getProxy());
            System.getProperties().put(HTTPS_PROXY_PORT, ENVIRONMENT.getPort());
        }
        RemoteWebDriver remoteWebdriver;
        try {
            remoteWebdriver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            LOGGER.warn(e.getMessage(), e);
            throw new RuntimeException();
        }
        return remoteWebdriver;

    }

}
