package com.mitrais.selasa.unittesting;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnitTestingApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void allItems_Basic() throws JSONException {
        String response = restTemplate.getForObject("/all-items", String.class);
        // insert into item values(1, 'Ball 1', 100, 1);
        // insert into item values(2, 'Ball 2', 200, 2);
        // insert into item values(3, 'Ball 3', 300, 3);
        JSONAssert.assertEquals("[{id:1, value:100}, {value:400}, {value:900}]", response, false);
    }

    @Test
    public void findItem_Basic() throws JSONException {
        String response = restTemplate.getForObject("/item/2", String.class);
        // insert into item values(1, 'Ball 1', 100, 1);
        // insert into item values(2, 'Ball 2', 200, 2);
        // insert into item values(3, 'Ball 3', 300, 3);
        JSONAssert.assertEquals("{id:2, value:400}", response, false);
    }

}
