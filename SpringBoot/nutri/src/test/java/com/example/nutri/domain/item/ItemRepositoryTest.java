package com.example.nutri.domain.item;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @After
    public void cleanup() {
        itemRepository.deleteAll();
    }

    @Test
    public void loadItem() {
        itemRepository.save(Item.builder()
                .title("알약")
                .lprice(1000)
                .description("그냥 약")
                .link("www.naver.com")
                .image("111.jpg")
                .build());
        List<Item> itemList = itemRepository.findAll();

        Item item = itemList.get(0);
        //Assert.assertThat(item.getTitle(), is("test"));
        //Assert.assertThat(item.getDescription(), is("test약"));
        assertThat(item.getTitle(), is("알약"));
        assertThat(item.getDescription(), is("그냥 약"));
    }
}
