package me.ywj.fmstore.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CartItem
 *
 * @author sheip9
 * @since 2023/10/24 14:20
 */
@NoArgsConstructor
@Data
public class CartItem {
    private Long id;
    private Long amount;
    private String name;
    //    private Byte[] pic;
    private Double price;
}
