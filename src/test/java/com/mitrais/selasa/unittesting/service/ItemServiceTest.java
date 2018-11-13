package com.mitrais.selasa.unittesting.service;

import com.mitrais.selasa.unittesting.model.Item;
import com.mitrais.selasa.unittesting.repository.ItemRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
    @InjectMocks
    private ItemService itemService;
    @Mock
    private ItemRepository itemRepository;

    @Test
    public void findItem_Basic(){
        // prepare
        when(itemRepository.findById(1)).thenReturn(Optional.of(new Item(1, "Glass", 200, 3)));

        // action
        Item item = itemService.findItem(1);

        // assertion
        assertEquals(600, item.getValue(), 0.0000001);
    }

    @Test
    public void findItems_Basic(){
        // prepare
        when(itemRepository.findAll()).thenReturn(Arrays.asList(
                new Item(1, "Ball 1", 100, 10),
                new Item(2, "Ball 2", 200, 20),
                new Item(3, "Ball 3", 300, 30)
        ));

        // action
        List<Item> allItems = itemService.findAllItems();

        // assertion
        assertEquals(1000, allItems.get(0).getValue(), 0.0000001);
        assertEquals(4000, allItems.get(1).getValue(), 0.0000001);
        assertEquals(9000, allItems.get(2).getValue(), 0.0000001);
    }

}