package com.example;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.InOrder;

public class WorkflowServiceTest {

    @Test
    public void testMethodCallOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);

        WorkflowService service = new WorkflowService(mockApi);
        service.executeWorkflow();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).start();
        inOrder.verify(mockApi).process();
        inOrder.verify(mockApi).end();
    }
}