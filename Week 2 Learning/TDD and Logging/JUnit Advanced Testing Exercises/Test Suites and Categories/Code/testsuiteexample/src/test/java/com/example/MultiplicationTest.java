package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {

    MathUtils math = new MathUtils();

    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(6, math.multiply(2, 3));
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0, math.multiply(5, 0));
    }
}
