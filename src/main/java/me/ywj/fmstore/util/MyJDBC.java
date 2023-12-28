package me.ywj.fmstore.util;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * MyJDBC
 *
 * @author sheip9
 * @since 2023/12/25 8:57
 */
public class MyJDBC {
    static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
    //定义数据库连接的参数
    /***
     * 驱动类名
     */
    private static final String DRIVER = rb.getString("driver");
    /**
     *数据库地址
     */
    private static final String URL = rb.getString("url");
    /**
     * 用户名
     */
    private static final String USER = rb.getString("username");
    /**
     * 密码
     */
    private static final String PASSWORD = rb.getString("password");

    //静态代码块，加载驱动类
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
    public Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
