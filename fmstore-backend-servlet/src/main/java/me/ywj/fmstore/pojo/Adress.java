package me.ywj.fmstore.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Adress
 *
 * @author sheip9
 * @since 2023/12/25 8:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress {
    private Integer id;
    private Integer user_id;
    private String address;
}
