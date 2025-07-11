package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

public class PerformanceTesterTest {

    @Test
    void testPerformTaskCompletesWithinTimeout() {
        PerformanceTester tester = new PerformanceTester();
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }
}
