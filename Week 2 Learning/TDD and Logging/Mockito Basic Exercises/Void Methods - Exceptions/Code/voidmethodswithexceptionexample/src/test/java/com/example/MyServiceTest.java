package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyServiceTest {

    @Test
    public void testDeleteDataThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Delete failed")).when(mockApi).deleteData("123");

        MyService service = new MyService(mockApi);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.performDelete("123");
        });

        assertEquals("Delete failed", exception.getMessage());
        verify(mockApi).deleteData("123");
    }
}