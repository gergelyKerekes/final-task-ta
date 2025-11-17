package com.epam.training.gergely_kerekes.tests;

import com.epam.training.gergely_kerekes.pages.InventoryPage;
import com.epam.training.gergely_kerekes.pages.LoginPage;
import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Login-related UI test for SauceDemo.
 */
public class LoginTests extends BaseTest{

    private static final Logger logger = LoggerUtil.getLogger(LoginTests.class);

    /**
     * UC-1: Empty credentials should result in "Username is required error.
     */
    @Test
    public void emptyCredentials() {
        logger.info("Executing test: emptyCredentials");
        String errorMsg = new LoginPage()
                .open()
                .typeUsername("anything")
                .typePassword("anything")
                .clearUsername()
                .clearPassword()
                .clickLoginExpectingError()
                .getError();

        assertThat(errorMsg).contains("Username is required");
    }

    /**
     * UC-2: Username only, missing password should show "Password is required".
     */
    @Test
    public void missingPassword() {
        logger.info("Executing test: missingPassword");
        String errorMsg = new LoginPage()
                .open()
                .typeUsername("anything")
                .typePassword("anything")
                .clearPassword()
                .clickLoginExpectingError()
                .getError();

        assertThat(errorMsg).contains("Password is required");
    }

    /**
     * UC-3: Valid login should land on the inventory page with title "Swag Labs".
     */
    @Test
    public void validLogin() {
        logger.info("Executing test: validLogin");
        InventoryPage page = new LoginPage()
                .open()
                .loginAsValidUser();

        assertThat(page.getTitle()).isEqualTo("Swag Labs");
    }

}
