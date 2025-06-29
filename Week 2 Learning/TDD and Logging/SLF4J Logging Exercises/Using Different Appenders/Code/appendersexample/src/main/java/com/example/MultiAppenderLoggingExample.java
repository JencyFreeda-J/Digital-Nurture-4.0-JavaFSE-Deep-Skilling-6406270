package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppenderLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppenderLoggingExample.class);

    public static void main(String[] args) {
        logger.debug("Debugging application startup");
        logger.info("Application is running");
        logger.warn("This is a warning message");
        logger.error("An error occurred while processing the request");
    }
}