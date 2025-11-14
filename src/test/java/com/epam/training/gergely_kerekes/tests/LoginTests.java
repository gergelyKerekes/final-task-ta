package com.epam.training.gergely_kerekes.tests;

import com.epam.training.gergely_kerekes.pages.InventoryPage;
import com.epam.training.gergely_kerekes.pages.LoginPage;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests extends BaseTest{

    //UC-1: Empty credentials
    @Test
    public void emptyCredentials() {
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

    //UC-2: Username only, missing password
    @Test
    public void missingPassword() {
        String errorMsg = new LoginPage()
                .open()
                .typeUsername("anything")
                .typePassword("anything")
                .clearPassword()
                .clickLoginExpectingError()
                .getError();

        assertThat(errorMsg).contains("Password is required");
    }

    //UC-3 Valid login
    @Test
    public void validLogin() {
        InventoryPage page = new LoginPage()
                .open()
                .loginAsValidUser();

        assertThat(page.getTitle()).isEqualTo("Swag Labs");
    }

}
