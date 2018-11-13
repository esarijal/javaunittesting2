package com.mitrais.selasa.unittesting.service;

import com.mitrais.selasa.unittesting.model.Item;
import com.mitrais.selasa.unittesting.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService implements IItemService {

    private ItemRepository itemRepository;

    @Autowired
    public void setItemRepository(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item findItem(int id) {
        Optional<Item> optItem = itemRepository.findById(id);
        if(!optItem.isPresent()){
            return null;
        }
        Item one = optItem.get();
        one.setValue(one.getPrice() * one.getQty());
        return one;
    }

    @Override
    public List<Item> findAllItems() {
        List<Item> all = itemRepository.findAll();
        all.forEach(item -> item.setValue(item.getPrice() * item.getQty()));
        return all;
    }
}
