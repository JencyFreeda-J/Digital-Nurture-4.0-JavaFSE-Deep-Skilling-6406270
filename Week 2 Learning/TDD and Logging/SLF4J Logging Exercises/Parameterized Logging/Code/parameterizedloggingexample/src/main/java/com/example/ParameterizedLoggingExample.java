package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Jency";
        int items = 5;
        double price = 99.99;

        logger.info("User {} has {} items in cart totaling ${}", username, items, price);
        logger.warn("Warning: User {} exceeded threshold with {} items.", username, items);
        logger.error("Error processing payment for user {}. Amount: ${}", username, price);
    }
}