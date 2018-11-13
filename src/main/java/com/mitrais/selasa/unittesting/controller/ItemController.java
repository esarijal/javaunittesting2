package com.mitrais.selasa.unittesting.controller;

import com.mitrais.selasa.unittesting.model.Item;
import com.mitrais.selasa.unittesting.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {

    private IItemService itemService;

    @Autowired
    public void setItemService(IItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/item-hardcoded")
    public Item getItemHardcoded(){
        return new Item(1, "Ball", 100, 10);
    }

    @GetMapping("/all-items-hardcoded")
    public List<Item> getAllItemsHardcoded(){
        return Arrays.asList(
                new Item(1, "Ball 1", 100, 10),
                new Item(2, "Ball 2", 200, 20),
                new Item(3, "Ball 3", 300, 30)
        );
    }

    @GetMapping("/item/{id}")
    public Item getItem(@PathVariable String id){
        return itemService.findItem(Integer.parseInt(id));
    }

    @GetMapping("/all-items")
    public List<Item> getAllItems(){
        return itemService.findAllItems();
    }
}
