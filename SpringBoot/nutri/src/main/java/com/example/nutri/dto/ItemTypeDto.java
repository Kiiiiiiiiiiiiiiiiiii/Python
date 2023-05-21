package com.example.nutri.dto;

import com.example.nutri.domain.item.ItemType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@NoArgsConstructor
public class ItemTypeDto {
    private String name;
    private String code;

    public ItemTypeDto(JSONObject itemTypeJson) {
        this.name = itemTypeJson.getString("name");
        this.code = itemTypeJson.getString("code");
    }

    public ItemType toEntity() {
        return ItemType.builder()
                .name(name)
                .code(code)
                .build();
    }
}
