package com.epam.training.gergely_kerekes.util;

import org.slf4j.*;

public class LoggerUtil {

    public static Logger getLogger(Class<?> c) {
        return LoggerFactory.getLogger(c);
    }
}
