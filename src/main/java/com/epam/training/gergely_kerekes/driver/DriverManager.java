package com.epam.training.gergely_kerekes.driver;

import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

public class DriverManager {

    private static final Logger logger = LoggerUtil.getLogger(DriverManager.class);
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

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
