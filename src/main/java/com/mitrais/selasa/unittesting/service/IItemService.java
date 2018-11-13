package com.mitrais.selasa.unittesting.service;

import com.mitrais.selasa.unittesting.model.Item;

import java.util.List;

public interface IItemService {
    Item findItem(int id);
    List<Item> findAllItems();
}
