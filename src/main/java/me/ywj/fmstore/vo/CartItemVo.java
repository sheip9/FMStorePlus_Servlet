package me.ywj.fmstore.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * CartItemVo
 *
 * @author sheip9
 * @since 2023/10/24 14:25
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartItemVo {
    private Long id;
    private Long user_id;
    private Long item_id;
    private Long amount;
    private String name;
//    private Byte[] pic;
    private Double price;
}
