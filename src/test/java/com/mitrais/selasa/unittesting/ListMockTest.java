package com.mitrais.selasa.unittesting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ListMockTest {

    private List<String> listMock = mock(List.class);

    @Test
    public void size_Basic(){
        when(listMock.size()).thenReturn(8).thenReturn(10).thenReturn(20);

        System.out.println(listMock.size());
        System.out.println(listMock.size());
        System.out.println(listMock.size());
    }

    @Test
    public void returnWithParameter(){
        when(listMock.get(0)).thenReturn("Hello World");

        String get0 = listMock.get(0);
        System.out.println(get0);

        when(listMock.get(1)).thenReturn("Hello World");
        String get1 = listMock.get(1);
        System.out.println(get1);

        when(listMock.get(anyInt())).thenReturn("Hello World ALL");
        System.out.println(listMock.get(20));
        System.out.println(listMock.get(120));
        System.out.println(listMock.get(30));
        System.out.println(listMock.get(50));
        System.out.println(listMock.get(1));
    }

    @Test
    public void verification_Basic(){
        // SUT
        listMock.get(0);

        verify(listMock, times(1)).get(0);
        verify(listMock, never()).get(1);

        listMock.get(1);

        verify(listMock, atLeastOnce()).get(anyInt());
        verify(listMock, atLeast(1)).get(anyInt());
        verify(listMock, atMost(2)).get(anyInt());
    }

    @Test
    public void mocking(){
        ArrayList mock =  mock(ArrayList.class);

        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        System.out.println(mock.size());
        when(mock.size()).thenReturn(4);
        System.out.println(mock.size());

    }

    @Test
    public void spying(){
        ArrayList mock =  spy(ArrayList.class);

        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");
        System.out.println(mock.size());

        mock.add("Hello 1");
        mock.add("Hello 1");
        mock.add("Hello 1");

        when(mock.size()).thenReturn(4);
        System.out.println(mock.size());
        mock.add("Hello 1");
        System.out.println(mock.size());
        mock.stream().forEach(System.out::println);

    }
}
