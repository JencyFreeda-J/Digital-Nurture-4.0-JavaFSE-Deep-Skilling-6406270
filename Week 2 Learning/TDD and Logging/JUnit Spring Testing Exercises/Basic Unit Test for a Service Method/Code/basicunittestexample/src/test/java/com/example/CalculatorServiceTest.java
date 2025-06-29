package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void testAdd() {
        int result = calculatorService.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }
}