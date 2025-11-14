package com.epam.training.gergely_kerekes.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeStrategy implements BrowserStrategy{
    @Override
    public WebDriver createDriver() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            options.addArguments("--headless=new");
        }

        return new ChromeDriver(options);
    }
}
