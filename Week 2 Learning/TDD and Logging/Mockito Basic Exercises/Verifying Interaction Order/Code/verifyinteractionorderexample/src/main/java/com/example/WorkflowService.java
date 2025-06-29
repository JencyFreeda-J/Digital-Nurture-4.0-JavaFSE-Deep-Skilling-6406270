package com.example;

public class WorkflowService {
    private final ExternalApi api;

    public WorkflowService(ExternalApi api) {
        this.api = api;
    }

    public void executeWorkflow() {
        api.start();
        api.process();
        api.end();
    }
}