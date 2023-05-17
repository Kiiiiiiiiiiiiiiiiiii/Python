package com.example.nutri.controllers;

import com.example.nutri.domain.item.ItemRepository;
import com.example.nutri.dto.ItemDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ItemController {

    private ItemRepository itemRepository;

    @PostMapping("/item")
    public void saveItem(@RequestBody ItemDto dto) {
        itemRepository.save(dto.toEntity());
    }
}
