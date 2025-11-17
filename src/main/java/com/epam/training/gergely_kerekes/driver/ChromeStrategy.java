package com.epam.training.gergely_kerekes.driver;

import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

public class ChromeStrategy implements BrowserStrategy{

    private static final Logger logger = LoggerUtil.getLogger(ChromeStrategy.class);

    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        if (headless) {
            logger.info("Starting Chrome in headless mode");
            options.addArguments("--headless=new");
        } else {
            logger.info("Starting Chrome in headed mode");
        }

        logger.debug("Creating new ChromeDriver instance");
        return new ChromeDriver(options);
    }
}
