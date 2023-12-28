package me.ywj.fmstore.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * CartItemVo
 *
 * @author sheip9
 * @since 2023/10/24 14:25
 */
@Data
public class CartItemVo {
    private Long id;
    private Long amount;
    private String name;
//    private Byte[] pic;
    private BigDecimal price;

    public CartItemVo(Long id, Long amount, String name, BigDecimal price) {
        this.id = id;
        this.amount = amount;
        this.name = name;
        this.price = price;
    }
}
