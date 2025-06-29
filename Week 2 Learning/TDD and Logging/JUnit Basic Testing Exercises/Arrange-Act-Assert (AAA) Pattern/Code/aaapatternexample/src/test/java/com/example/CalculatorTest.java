package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        // Setup - runs before each test
        calculator = new Calculator();
    }

    @AfterEach
    void tearDown() {
        // Teardown - runs after each test
        calculator = null;
    }

    @Test
    void testAddition() {
        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testSubtraction() {
        // Arrange
        int a = 10;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(7, result);
    }
}
