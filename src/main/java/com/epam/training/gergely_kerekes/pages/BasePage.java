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

public abstract class BasePage {
    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    private static final Logger logger = LoggerUtil.getLogger(BasePage.class);

    protected WebElement find(By locator) {
        logger.debug("Finding element: {}", locator);
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        logger.info("Clicking element: {}", locator);
        find(locator).click();
    }

    protected void type(By locator, String text) {
        logger.info("Typing '{}' into element: {}", text, locator);
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

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
