package com.example.nutri.domain.item;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    private Integer lprice;
    @Column
    private String description;
    @Column(length = 500, nullable = false)
    private String link;
    @Column(length = 500)
    private String image;
    @ManyToOne
    @JoinColumn(name = "itemType_id")
    private ItemType itemType;

    @Builder
    public Item(String title, Integer lprice, String description, String link, String image, ItemType itemType) {
        this.title = title;
        this.lprice = lprice;
        this.description = description;
        this.link = link;
        this.image = image;
        this.itemType = itemType;
    }

}
