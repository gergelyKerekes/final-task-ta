package com.epam.training.gergely_kerekes.pages;

import com.epam.training.gergely_kerekes.driver.DriverManager;
import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;

import java.time.Duration;

/**
 * Base class for all the objects, providing common WebDriver helpers.
 */
public abstract class BasePage {
    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private static final Logger logger = LoggerUtil.getLogger(BasePage.class);

    /**
     * Finds a web element using the given locator.
     *
     * @param locator element locator
     * @return web element
     */
    protected WebElement find(By locator) {
        logger.debug("Finding element: {}", locator);
        return driver.findElement(locator);
    }

    /**
     * Clicks on the element lacated by the given locator
     *
     * @param locator element locator
     */
    protected void click(By locator) {
        logger.info("Clicking element: {}", locator);
        find(locator).click();
    }

    /**
     * Types text into the lement located by the given locator
     *
     * @param locator element locator
     * @param text text to type
     */
    protected void type(By locator, String text) {
        logger.info("Typing '{}' into element: {}", text, locator);
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Clears an input field and waits until it is empty
     *
     * @param locator input field locator
     */
    protected void clearAndWait(By locator) {
        logger.info("Clearing field and waiting to be emtpy: {}", locator);
        WebElement element = find(locator);
        element.click();

        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        wait.until(driver -> element.getAttribute("value").isEmpty());

        driver.findElement(By.tagName("body")).click();
    }
}
