package com.epam.training.gergely_kerekes.pages;

import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.openqa.selenium.By;
import org.slf4j.Logger;

/**
 * Page object representing the invetnory page after successful login.
 */
public class InventoryPage extends BasePage{

    private static final Logger logger = LoggerUtil.getLogger(InventoryPage.class);
    public static final By APP_LOGO = By.cssSelector(".app_logo");

    /**
     * Returns the title text displayed on the inventory page.
     *
     * @return title text
     */
    public String getTitle() {
        String title = find(APP_LOGO).getText();
        logger.info("Inventory page title: {}", title);
        return title;
    }
}
