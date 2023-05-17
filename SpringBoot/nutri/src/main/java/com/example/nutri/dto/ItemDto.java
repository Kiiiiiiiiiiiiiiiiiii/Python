package com.example.nutri.dto;

import com.example.nutri.domain.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

@Getter
@Setter
@NoArgsConstructor
public class ItemDto {
    private String title;
    private int lprice;
    private String description;
    private String link;
    private String image;

    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }

    public Item toEntity() {
        return Item.builder()
                .title(title)
                .lprice(lprice)
                .description(description)
                .link(link)
                .image(image)
                .build();
    }
}