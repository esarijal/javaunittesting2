package com.mitrais.selasa.unittesting.controller;

import com.mitrais.selasa.unittesting.model.Item;
import com.mitrais.selasa.unittesting.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Test
    public void itemHardcoded_Basic() throws Exception {
        // call GET /hello-world content-type:text/plain
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item-hardcoded");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{id:1, qty:10}"));

    }

    @Test
    public void allItemHardcoded_Basic() throws Exception {
        // call GET /hello-world content-type:text/plain
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items-hardcoded");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{}, {}, {}]"));

    }

    @Test
    public void getItem_Basic() throws Exception {
        // prepare
        when(itemService.findItem(1)).thenReturn(
                new Item(1, "Ball 1", 100, 10)
        );

        // call GET /item/1 content-type:text/plain
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/item/1");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "{id:1}"));

    }

    @Test
    public void findAllItems_Basic() throws Exception {
        // prepare
        when(itemService.findAllItems()).thenReturn(
                Arrays.asList(
                        new Item(1, "Ball 1", 100, 10),
                        new Item(2, "Ball 2", 200, 20),
                        new Item(3, "Ball 3", 300, 30)
                )
        );

        // call GET /item/1 content-type:text/plain
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/all-items");

        mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().json(
                        "[{}, {}, {}]"));

    }


}