package com.epam.training.gergely_kerekes.config;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties PROPERTIES = new Properties();

    static {
        try(var input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IllegalStateException("config.properties not found in resources folder");
            }

            PROPERTIES.load(input);


        } catch (IOException e) {
            throw new IllegalStateException("Failed to load config.properties");
        }
    }

    public static String getBaseUrl() {
        return PROPERTIES.getProperty("base.url");
    }

}
