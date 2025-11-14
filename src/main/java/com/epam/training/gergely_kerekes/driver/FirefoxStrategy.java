package com.epam.training.gergely_kerekes.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxStrategy implements BrowserStrategy {
    @Override
    public WebDriver createDriver() {
        FirefoxOptions options = new FirefoxOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("-headless");
        }
        return new FirefoxDriver(options);
    }
}
