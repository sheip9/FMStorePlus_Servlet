package me.ywj.fmstore.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {
    private Long id;
    private String name;
    private String des;
    private String price;

    public ItemDto(String name, String des, String price) {
        this.name = name;
        this.des = des;
        this.price = price;
    }

    public ItemDto(Long id) {
        this.id = id;
    }
}
