package com.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

@TestMethodOrder(OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(1)
    void testInitialize() {
        System.out.println("Test 1 - Initialize");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(3)
    void testCleanup() {
        System.out.println("Test 3 - Cleanup");
        Assertions.assertTrue(true);
    }

    @Test
    @Order(2)
    void testProcess() {
        System.out.println("Test 2 - Process");
        Assertions.assertTrue(true);
    }
}