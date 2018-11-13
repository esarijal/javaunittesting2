package com.mitrais.selasa.unittesting.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest {

    // SUT - System Under Test
    @InjectMocks
    private SomeBusiness someBusiness;

    // dependencies
    @Mock
    private SomeDataService someDataService;

    @Test
    public void calculateSumFromService_Basic(){
        // preparation
        when(someDataService.retrieveAllData()).thenReturn(new int[] {1, 2, 3});

        // action
        int response = someBusiness.calculateSumFromService();

        // assertion
        assertEquals(6, response);
    }

    @Test
    public void calculateSumFromService_Empty(){
        // preparation
        when(someDataService.retrieveAllData()).thenReturn(new int[] {});

        // action
        int response = someBusiness.calculateSumFromService();

        // assertion
        assertEquals(0, response);
    }

}