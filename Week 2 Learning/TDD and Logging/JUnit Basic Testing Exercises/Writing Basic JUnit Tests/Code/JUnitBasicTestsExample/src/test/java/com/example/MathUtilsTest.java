package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    MathUtils utils = new MathUtils();

    @Test
    void testAdd() {
        assertEquals(10, utils.add(7, 3));
    }

    @Test
    void testSubtract() {
        assertEquals(4, utils.subtract(9, 5));
    }

    @Test
    void testMultiply() {
        assertEquals(20, utils.multiply(4, 5));
    }

    @Test
    void testDivide() {
        assertEquals(3, utils.divide(9, 3));
    }

    @Test
    void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            utils.divide(10, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
