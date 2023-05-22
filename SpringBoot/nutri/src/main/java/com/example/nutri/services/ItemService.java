package com.example.nutri.services;

import com.example.nutri.domain.item.Item;
import com.example.nutri.domain.item.ItemRepository;
import com.example.nutri.dto.ItemDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class ItemService {
    private ItemRepository itemRepository;

    @Transactional
    public Long saveItem(ItemDto dto) {
        return itemRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public Long updateItem(ItemDto dto) {
        return itemRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<Item> getItemByTypeId(Long itemTypeId) {
        return (List<Item>) itemRepository.findAllByItemTypeId(itemTypeId);
    }
}
