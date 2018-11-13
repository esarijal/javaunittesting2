package com.mitrais.selasa.unittesting.service;

import java.util.Arrays;

public class SomeBusiness {
    private SomeDataService someDataService;

    public int calculateSum(int[] numbers){
        return Arrays.stream(numbers).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumFromService(){
        int[] numbers = someDataService.retrieveAllData();
        return Arrays.stream(numbers).reduce(Integer::sum).orElse(0);
    }

    public void setSomeDataService(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }
}
