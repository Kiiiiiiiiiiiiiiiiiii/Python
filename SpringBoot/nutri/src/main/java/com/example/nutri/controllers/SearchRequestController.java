package com.example.nutri.controllers;

import com.example.nutri.dto.ItemDto;
import com.example.nutri.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController // JSON으로 응답함을 선언합니다.
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query) {
        // ? 뒤에 오는 넘을 쓰고 싶다면 @RequestParam 필수
        String resultString = naverShopSearch.search();
        return naverShopSearch.fromJSONtoItems(resultString);
    }
}