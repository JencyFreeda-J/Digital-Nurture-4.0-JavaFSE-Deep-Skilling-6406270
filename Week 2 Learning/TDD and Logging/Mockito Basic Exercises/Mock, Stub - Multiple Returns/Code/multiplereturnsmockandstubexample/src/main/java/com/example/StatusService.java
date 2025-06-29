package com.example;

public class StatusService {
    private final ExternalApi externalApi;

    public StatusService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String checkStatusMultipleTimes() {
        String first = externalApi.getStatus();
        String second = externalApi.getStatus();
        return first + " & " + second;
    }
}