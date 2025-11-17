package com.epam.training.gergely_kerekes.config;


import com.epam.training.gergely_kerekes.util.LoggerUtil;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class Config {

    private static final Logger logger = LoggerUtil.getLogger(Config.class);
    private static final Properties PROPERTIES = new Properties();

    static {
        try(var input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                logger.error("config.properties not found in resources folder");
                throw new IllegalStateException("config.properties not found in resources folder");
            }

            PROPERTIES.load(input);
            logger.info("Configuration loaded succesfully from config.properties");

        } catch (IOException e) {
            logger.error("Failed to load config.properties");
            throw new IllegalStateException("Failed to load config.properties");
        }
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }

}
