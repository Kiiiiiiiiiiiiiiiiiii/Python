package com.example.nutri.services;

import com.example.nutri.domain.item.ItemRepository;
import com.example.nutri.dto.ItemDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Transactional
    public Long save(ItemDto dto) {
        return itemRepository.save(dto.toEntity()).getId();
    }
}
