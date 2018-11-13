package com.mitrais.selasa.unittesting.repository;

import com.mitrais.selasa.unittesting.model.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void testFindAll(){
        List<Item> all = itemRepository.findAll();
        assertEquals(3, all.size());
    }

    @Test
    public void testGetOne(){
        // insert into item values(1, 'Ball 1', 100, 1);
        // insert into item values(2, 'Ball 2', 200, 2);
        // insert into item values(3, 'Ball 3', 300, 3);
        Item one = itemRepository.getOne(1);
        assertEquals(one.getId(), 1);
    }
}
