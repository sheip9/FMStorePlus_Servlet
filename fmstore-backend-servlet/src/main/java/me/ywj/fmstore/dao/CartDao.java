package me.ywj.fmstore.dao;

import me.ywj.fmstore.pojo.CartItem;
import me.ywj.fmstore.util.JDBCUtil;
import me.ywj.fmstore.util.MyJDBC;
import me.ywj.fmstore.vo.CartItemVo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * CartDao
 *
 * @author sheip9
 * @since 2023/10/24 14:35
 */
public class CartDao extends MyDao<CartItem>{
    public int insert(CartItem cartItem) {
        JDBCUtil jdbc = new JDBCUtil(cartItem);
        int res = jdbc.executeInsert();
        jdbc.close();
        return res;
    }

    public List<CartItemVo> query(Long userId) {
        MyJDBC jdbc = new MyJDBC();
        try {
            String sql = "SELECT cart.id, cart.amount, item.`name`, item.price FROM `cart` LEFT JOIN `item` ON item_id = item.id WHERE user_id = ?;";
            PreparedStatement ps = jdbc.getConnection().prepareStatement(sql);
            ps.setLong(1, userId);
            return super.listAs(ps, CartItemVo.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
