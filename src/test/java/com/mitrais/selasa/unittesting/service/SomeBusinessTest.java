package com.mitrais.selasa.unittesting.service;

import org.junit.Test;

import static org.junit.Assert.*;

public class SomeBusinessTest {
    @Test
    public void calculateSum_Basic(){
        SomeBusiness someBusiness = new SomeBusiness();
        assertEquals(6, someBusiness.calculateSum(new int[] {1, 2, 3}));
    }

    @Test
    public void calculateSum_Empty(){
        SomeBusiness someBusiness = new SomeBusiness();
        assertEquals(0, someBusiness.calculateSum(new int[] {}));
    }

    @Test
    public void calculateSum_OneValue(){
        SomeBusiness someBusiness = new SomeBusiness();
        assertEquals(2, someBusiness.calculateSum(new int[] {2}));
    }


    @Test
    public void calculateSumFromService_Basic(){
        SomeBusiness someBusiness = new SomeBusiness();
        someBusiness.setSomeDataService(new SomeDataService() {
            @Override
            public int[] retrieveAllData() {
                return new int[]{1, 2, 3};
            }
        });
        assertEquals(6, someBusiness.calculateSumFromService());
    }

}