package com.epam.training.gergely_kerekes.pages;

import com.epam.training.gergely_kerekes.config.Config;
import com.epam.training.gergely_kerekes.model.Credentials;
import com.epam.training.gergely_kerekes.model.Users;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("h3[data-test='error']");

    public LoginPage open() {
        driver.get(Config.getBaseUrl());
        return this;
    }

    public LoginPage typeUsername(String username) {
        type(USERNAME_INPUT, username);
        return this;
    }

    public LoginPage typePassword(String password) {
        type(PASSWORD_INPUT, password);
        return this;
    }

    public LoginPage clearUsername() {
        clearAndWait(USERNAME_INPUT);
        return this;
    }

    public LoginPage clearPassword() {
        clearAndWait(PASSWORD_INPUT);
        return this;
    }

    public String getError() {
        return find(ERROR_MESSAGE).getText();
    }

    public LoginPage clickLoginExpectingError() {
        click(LOGIN_BUTTON);
        return this;
    }

//    public InventoryPage clickLogin() {
//        click(LOGIN_BUTTON);
//        return new InventoryPage();
//    }

    public InventoryPage loginAs(Credentials credentials) {
        typeUsername(credentials.getUsername());
        typePassword(credentials.getPassword());
        click(LOGIN_BUTTON);
        return new InventoryPage();
    }

    public InventoryPage loginAsValidUser() {
        return loginAs(Users.standardUser());
    }

}
