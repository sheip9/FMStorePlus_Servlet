package me.ywj.fmstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * CartDto
 *
 * @author sheip9
 * @since 2023/10/24 14:36
 */
@Data
@AllArgsConstructor
public class CartDto {
    private Long user_id;
    private Long product_id;
    private Long amount;
}
