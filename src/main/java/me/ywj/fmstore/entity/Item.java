package me.ywj.fmstore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class Item {

    private Long id;
    private String name;
    private String des;
    private Byte[] pic;
    private Double price;
    private Long click;
    private Long crtTime;

    public Item(Long id, String name, String des, Double price) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
    }
}
