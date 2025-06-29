package com.example;

public class ExceptionThrower {
    public void throwException(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Input must not be null or blank");
        }
        System.out.println("Valid input: " + input);
    }
}