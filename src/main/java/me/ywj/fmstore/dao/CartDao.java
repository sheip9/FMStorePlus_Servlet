package me.ywj.fmstore.dao;

import me.ywj.fmstore.pojo.CartItem;
import me.ywj.fmstore.util.JDBCUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
    public static ArrayList<CartItem> query(Long userId){
        String sql = "SELECT cart.id, cart.amount, item.`name`, item.price FROM `cart` LEFT JOIN `item` ON item_id = item.id WHERE user_id = ?;";
        JDBCUtil j = new JDBCUtil(new Object());
        ResultSet rs = j.specialQuery(sql, userId);
        ArrayList<CartItem> list = new ArrayList<>();
        try {
            while (Objects.requireNonNull(rs).next()){
                CartItem cartItem = new CartItem();
                cartItem.setId(rs.getLong(1));
                cartItem.setAmount(rs.getLong(2));
                cartItem.setName(rs.getString(3));
                cartItem.setPrice(rs.getDouble(4));
                list.add(cartItem);
                j.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
