package com.backend.api.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class CalculatorServiceTest {
    @Mock
    private CalculatorService calculatorService;
    @InjectMocks
    private CalculatorServiceTest calculatorServiceTest;

    @Test
    public void testAdd() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);
        // Set up the mock behavior
        when(calculatorService.add(3, 3)).thenReturn(6);
        // Call the method and assert the result
        assertEquals(5, calculatorService.add(3, 3));
    }
}
