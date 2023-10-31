package me.ywj.fmstore.entity;

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
    private Long user_id;
    private Long item_id;
    private Long amount;
}
