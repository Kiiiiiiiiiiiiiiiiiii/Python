package com.example.nutri.controllers;

import com.example.nutri.domain.item.Item;
import com.example.nutri.domain.item.ItemRepository;
import com.example.nutri.dto.ItemDto;
import com.example.nutri.dto.exception.ResourceNotFoundException;
import com.example.nutri.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ItemController {

    private ItemRepository itemRepository;
    private ItemService itemService;

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Long id){
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist : " + id));
        return ResponseEntity.ok(item);
    }

    @GetMapping("/items")
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
    @PostMapping("/item/save")
    public void saveItem(@RequestBody ItemDto dto) {
        //itemRepository.save(dto.toEntity());
        itemService.saveItem(dto);
    }

    @PutMapping("/item/update{id}")
    public void updateItem(@RequestBody ItemDto dto){
        itemService.updateItem(dto);
    }

    @DeleteMapping("item/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteItem(@PathVariable Long id) {
        itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not exist : " + id));
        itemRepository.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
