package me.ywj.fmstore.dao;

import me.ywj.fmstore.entity.Item;
import me.ywj.fmstore.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDao {
    public static int insert(Item item) {
        JDBCUtil jdbc = new JDBCUtil(item);
        int res = jdbc.executeInsert();
        jdbc.close();
        return res;
    }

    public static int delete(Item item) {
        JDBCUtil jdbc = new JDBCUtil(item);
        int res = jdbc.executeDelete();
        jdbc.close();
        return res;
    }

    public static int update(Item condItem, Item vluItem) {
        JDBCUtil jdbc = new JDBCUtil(condItem);
        int res = jdbc.executeUpdate(vluItem);
        jdbc.close();
        return res;
    }

    public static List<Item> query() {
        List<Item> list = new ArrayList<>();
        ResultSet rs;
        try {
            JDBCUtil j = new JDBCUtil(new Item());
            rs = j.executeQuery();
            while (rs.next()) {
                list.add(new Item(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4)
                ));
            }
            j.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
