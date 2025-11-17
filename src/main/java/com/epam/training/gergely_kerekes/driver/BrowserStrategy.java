package com.epam.training.gergely_kerekes.driver;

import org.openqa.selenium.WebDriver;


/**
 * Strategy interface for creating WebDriver instance
 */
public interface BrowserStrategy {

    /**
     * Creates a configured WebDriver instance
     *
     * @return a new WebDriver
     */
    WebDriver createDriver();
}
