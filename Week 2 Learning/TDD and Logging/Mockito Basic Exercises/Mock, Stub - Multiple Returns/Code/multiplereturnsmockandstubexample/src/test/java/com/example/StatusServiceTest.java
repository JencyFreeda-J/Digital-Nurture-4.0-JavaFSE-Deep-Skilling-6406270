package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StatusServiceTest {

    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getStatus()).thenReturn("Pending", "Completed");

        StatusService service = new StatusService(mockApi);
        String result = service.checkStatusMultipleTimes();

        assertEquals("Pending & Completed", result);
    }
}