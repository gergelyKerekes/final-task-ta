package com.epam.training.gergely_kerekes.pages;

import com.epam.training.gergely_kerekes.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver = DriverManager.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clearAndWait(By locator) {
        WebElement element = find(locator);
        element.click();

        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        wait.until(driver -> element.getAttribute("value").isEmpty());

        driver.findElement(By.tagName("body")).click();
    }
}
