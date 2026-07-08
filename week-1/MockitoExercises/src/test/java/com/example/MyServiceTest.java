package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.ArgumentMatchers.endsWith;
import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.ArgumentMatchers.startsWith;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

public class MyServiceTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @BeforeEach
    void setUp() {
        mockApi = mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    // EXERCISE 1: Mocking and Stubbing
    @Test
    public void testFetchData() {
        when(mockApi.getData()).thenReturn("Mock Data");
        String result = service.fetchData();
        assertEquals("Mock Data", result);
        verify(mockApi).getData();
    }
    
    @Test
    public void testFetchDataMultipleStubs() {
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call");
        
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
    }
    
    @Test
    public void testCheckStatus() {
        when(mockApi.getStatusCode()).thenReturn(200);
        int status = service.checkStatus();
        assertEquals(200, status);
        verify(mockApi).getStatusCode();
    }

    // EXERCISE 2: Verifying Interactions
    @Test
    public void testVerifyInteraction() {
        service.fetchData();
        verify(mockApi).getData();
    }
    
    @Test
    public void testVerifyWithArguments() {
        service.registerUser("john_doe", "password123");
        verify(mockApi).saveUser("john_doe", "password123");
    }
    
    @Test
    public void testVerifyWithMatchers() {
        service.registerUser("alice", "secret456");
        verify(mockApi).saveUser(anyString(), anyString());
        verify(mockApi).saveUser(startsWith("alice"), contains("456"));
    }
    
    @Test
    public void testVerifyCallCount() {
        service.fetchData();
        service.fetchData();
        service.fetchData();
        verify(mockApi, times(3)).getData();
    }
    
    @Test
    public void testVerifyMultipleCallsWithDifferentArgs() {
        service.registerUser("user1", "pass1");
        service.registerUser("user2", "pass2");
        verify(mockApi).saveUser("user1", "pass1");
        verify(mockApi).saveUser("user2", "pass2");
    }
    
    @Test
    public void testVerifyNoInteractions() {
        verifyNoInteractions(mockApi);
    }
    
    @Test
    public void testVerifyOrder() {
        service.fetchData();
        service.checkStatus();
        service.saveData("test");
        
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).getStatusCode();
        inOrder.verify(mockApi).updateData("test");
    }

    @Test
    public void completeVerificationExample() {
        service.registerUser("john", "pass123");
        service.fetchData();
        service.fetchData();
        service.checkStatus();
        service.removeRecord(100L);
        
        verify(mockApi).saveUser("john", "pass123");
        verify(mockApi, times(2)).getData();
        verify(mockApi, times(1)).getStatusCode();
        verify(mockApi, times(1)).deleteRecord(100L);
        
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).saveUser("john", "pass123");
        inOrder.verify(mockApi, times(2)).getData();
        inOrder.verify(mockApi).getStatusCode();
        inOrder.verify(mockApi).deleteRecord(100L);
        
        verifyNoMoreInteractions(mockApi);
    }

    // EXERCISE 3: Argument Matching
    @Test
    public void testBasicArgumentMatchers() {
        service.registerUser("john_doe", "password123");
        verify(mockApi).saveUser(anyString(), anyString());
        
        service.modifyUser(1, "John", "john@email.com");
        verify(mockApi).updateUser(anyInt(), anyString(), anyString());
    }
    
    @Test
    public void testStringMatchers() {
        service.registerUser("alice_wonder", "secret123");
        
        verify(mockApi).saveUser(startsWith("alice"), anyString());
        verify(mockApi).saveUser(anyString(), endsWith("123"));
        verify(mockApi).saveUser(contains("_wonder"), anyString());
        verify(mockApi).saveUser(matches("^[a-z]+_[a-z]+$"), anyString());
    }
}
