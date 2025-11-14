package com.epam.training.gergely_kerekes.pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage{

    public static final By APP_LOGO = By.cssSelector(".app_logo");

    public String getTitle() {
        return find(APP_LOGO).getText();
    }
}
