package com.epam.training.gergely_kerekes.driver;

import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;

/**
 * Firefox-specific WebDriver creation strategy
 */
public class FirefoxStrategy implements BrowserStrategy {

    private static final Logger logger = LoggerUtil.getLogger(FirefoxStrategy.class);

    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (headless) {
            logger.info("starting Firefox in headless mode");
            options.addArguments("-headless");
        } else {
            logger.info("starting Firefox in headed mode");
        }

        logger.debug("Creating new FirefoxDriver instance");
        return new FirefoxDriver(options);
    }
}
