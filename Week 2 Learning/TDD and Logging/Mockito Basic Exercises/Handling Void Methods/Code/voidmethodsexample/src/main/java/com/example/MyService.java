package com.example;

public class MyService {
    private final LoggerService loggerService;

    public MyService(LoggerService loggerService) {
        this.loggerService = loggerService;
    }

    public void doWork() {
        // Perform some work (can be simulated)
        loggerService.log("Work done");
    }
}