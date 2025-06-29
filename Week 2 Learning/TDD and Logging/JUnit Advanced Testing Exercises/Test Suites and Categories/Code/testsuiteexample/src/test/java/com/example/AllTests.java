package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        AdditionTest.class,
        MultiplicationTest.class
})
public class AllTests {
    // This class remains empty. It is used only as a holder for the above
    // annotations.
}