package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AdditionTest {

    MathUtils math = new MathUtils();

    @Test
    void testAddPositiveNumbers() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, math.add(-2, -3));
    }
}