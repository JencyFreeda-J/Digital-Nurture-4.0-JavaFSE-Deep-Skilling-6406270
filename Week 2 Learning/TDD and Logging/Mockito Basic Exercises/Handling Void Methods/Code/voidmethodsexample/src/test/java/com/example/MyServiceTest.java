package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testVoidMethodLogging() {
        LoggerService mockLogger = mock(LoggerService.class);
        MyService service = new MyService(mockLogger);

        service.doWork();

        verify(mockLogger).log("Work done");
    }
}