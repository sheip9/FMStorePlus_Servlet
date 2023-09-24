package me.ywj.fmstore.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private Long id;
    private String name;
    private String des;
    private Double price;
    private Long crtTime;

    public Item() {

    }
    public Item(Long id, String name, String des, Double price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
    }
}
