package me.ywj.fmstore.dao;

import me.ywj.fmstore.entity.CartItem;
import me.ywj.fmstore.util.JDBCUtil;

/**
 * CartDao
 *
 * @author sheip9
 * @since 2023/10/24 14:35
 */
public class CartDao {
    public static int insert(CartItem cartItem) {
        JDBCUtil jdbc = new JDBCUtil(cartItem);
        int res = jdbc.executeInsert();
        jdbc.close();
        return res;
    }
}
