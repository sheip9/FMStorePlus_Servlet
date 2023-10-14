package me.ywj.fmstore.dao;

import me.ywj.fmstore.entity.User;
import me.ywj.fmstore.util.JDBCUtil;

import java.sql.ResultSet;

public class UserDao {
    public static int insert(User user){
        JDBCUtil j = new JDBCUtil(user);
        return j.executeInsert();
    }
    public static User query(User user){
        JDBCUtil j = new JDBCUtil(new User());
        ResultSet rs = j.executeQuery(user);
        User result = null;
        try {
            rs.next();
            result = new User(rs.getLong(1), rs.getString(2), rs.getNString(3),rs.getInt(4),rs.getLong(5) );
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
