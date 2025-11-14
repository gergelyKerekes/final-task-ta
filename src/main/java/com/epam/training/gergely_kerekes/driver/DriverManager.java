package com.epam.training.gergely_kerekes.driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (DRIVER.get() == null) {
            BrowserType type = BrowserType.valueOf(System.getProperty("browser", "CHROME").toUpperCase());
            BrowserStrategy strategy =
                    (type == BrowserType.FIREFOX) ? new FirefoxStrategy() : new ChromeStrategy();

            DRIVER.set(strategy.createDriver());
        }
        return DRIVER.get();
    }

    public static void quitDriver() {
        if (DRIVER.get() != null) {
            DRIVER.get().quit();
            DRIVER.remove();
        }
    }
}
