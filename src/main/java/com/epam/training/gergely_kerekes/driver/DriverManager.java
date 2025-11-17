package com.epam.training.gergely_kerekes.driver;

import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

/**
 * Manages the WebDriver lifecycle using ThreadLocal insatnce.
 */
public class DriverManager {

    private static final Logger logger = LoggerUtil.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    /**
     * Returns the WebDriver for the current thread, creating one is needed.
     *
     * @return WebDriver insatnce for current thread
     */
    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            BrowserType type = BrowserType.valueOf(System.getProperty("browser", "CHROME").toUpperCase());
            logger.info("Initializing WebDriver for browser: {}", type);

            BrowserStrategy strategy =
                    (type == BrowserType.FIREFOX) ? new FirefoxStrategy() : new ChromeStrategy();

            DRIVER.set(strategy.createDriver());
            logger.debug("WebDriver stored in Threadlocal for thread {}", Thread.currentThread().getId());
        }
        return DRIVER.get();
    }

    /**
     * Quits and removes the WebDriver for the current thread.
     */
    public static void quitDriver() {
        if (DRIVER.get() != null) {
            logger.info("Quitting Webdriver for thread {}", Thread.currentThread().getId());
            DRIVER.get().quit();
            DRIVER.remove();
        } else {
            logger.warn("quitDirver() called but no WebDriver is associated with this thread");
        }
    }
}
