package com.epam.training.gergely_kerekes.tests;

import com.epam.training.gergely_kerekes.driver.DriverManager;
import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.slf4j.Logger;
import org.testng.annotations.AfterMethod;

public abstract class BaseTest {

    private static final Logger logger = LoggerUtil.getLogger(BaseTest.class);

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        logger.info("Tearing down WebDriver after the test method");
        DriverManager.quitDriver();
    }
}
