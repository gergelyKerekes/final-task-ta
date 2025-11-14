package com.epam.training.gergely_kerekes.tests;

import com.epam.training.gergely_kerekes.driver.DriverManager;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
