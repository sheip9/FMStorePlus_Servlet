package me.ywj.fmstore.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemVo {
    private Long id;
    private String name;
    private String des;
    private String price;
    public ItemVo(){

    }

    public void setPrice(String price) {
        this.price = String.format("%.2f", Double.parseDouble(price));
    }

}
