package com.mitrais.selasa.unittesting.repository;

import com.mitrais.selasa.unittesting.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
