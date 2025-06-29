package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    @Test
    void testThrowsExceptionForNullInput() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
    }

    @Test
    void testThrowsExceptionForBlankInput() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("   ");
        });
    }

    @Test
    void testNoExceptionForValidInput() {
        ExceptionThrower thrower = new ExceptionThrower();
        assertDoesNotThrow(() -> {
            thrower.throwException("Hello");
        });
    }
}
