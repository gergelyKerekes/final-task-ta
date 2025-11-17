package com.epam.training.gergely_kerekes.pages;

import com.epam.training.gergely_kerekes.config.Config;
import com.epam.training.gergely_kerekes.model.Credentials;
import com.epam.training.gergely_kerekes.model.Users;
import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.By;
import org.slf4j.Logger;

public class LoginPage extends BasePage{

    private static Logger logger = LoggerUtil.getLogger(LoginPage.class);

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_MESSAGE = By.cssSelector("h3[data-test='error']");

    public LoginPage open() {
        String url = Config.getBaseUrl();
        logger.info("Opening login page: {}", url);
        driver.get(url);
        return this;
    }

    public LoginPage typeUsername(String username) {
        logger.info("Typing username");
        type(USERNAME_INPUT, username);
        return this;
    }

    public LoginPage typePassword(String password) {
        logger.info("Typing password");
        type(PASSWORD_INPUT, password);
        return this;
    }

    public LoginPage clearUsername() {
        logger.info("Clearing username field");
        clearAndWait(USERNAME_INPUT);
        return this;
    }

    public LoginPage clearPassword() {
        logger.info("Clearing password field");
        clearAndWait(PASSWORD_INPUT);
        return this;
    }

    public String getError() {
        String error = find(ERROR_MESSAGE).getText();
        logger.info("Current login error message: {}", error);
        return error;
    }

    public LoginPage clickLoginExpectingError() {
        logger.info("Clicking login expecting an error");
        click(LOGIN_BUTTON);
        return this;
    }


    public InventoryPage loginAs(Credentials credentials) {
        logger.info("Logging in as provided credentials");
        typeUsername(credentials.getUsername());
        typePassword(credentials.getPassword());
        click(LOGIN_BUTTON);
        return new InventoryPage();
    }

    public InventoryPage loginAsValidUser() {
        logger.info("Logging in as standard user");
        return loginAs(Users.standardUser());
    }

}
