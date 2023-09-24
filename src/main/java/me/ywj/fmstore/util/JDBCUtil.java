package me.ywj.fmstore.util;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

public class JDBCUtil {

    static ResourceBundle rb = ResourceBundle.getBundle("jdbc");
    //定义数据库连接的参数
    private static final String DRIVER = rb.getString("driver"); //驱动类名
    private static final String URL = rb.getString("url"); //数据库地址
    private static final String USER = rb.getString("username"); //用户名
    private static final String PASSWORD = rb.getString("password"); //密码

    //静态代码块，加载驱动类
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    private final Object obj;
    private final String clzName;
    private final Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public JDBCUtil(Object o) {
        conn = getConnection();
        this.obj = o;
        this.clzName = getClassName(o);
    }
    private static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    private static String getClassName(Object obj) {
        Class<?> clz = obj.getClass();
        String className = clz.getSimpleName();
        //filter
//        Pattern p  = Pattern.compile("^person (\\\\d{4}-\\\\d{2}-\\\\d{2})$");
//        Matcher matcher = pattern.matcher(className);
//        if(matcher.find()){
//            return className;
//        }else{
//            throw new RuntimeException("有人想搞事情");
//        }
        return className;
    }
    private static String montageWithComma(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(strArr[i]);
            if (i != length - 1) sb.append(",");
        }
        return sb.toString();
    }
    private static String montageWithEqualSign(String[][] strArr) {
        StringBuilder sb = new StringBuilder();
        int length = strArr[0].length;
        for (int i = 0; i < length; i++) {
            sb.append(strArr[0][i]).append("=").append(strArr[1][i]);
            if (i != length - 1) sb.append(",");
        }
        return sb.toString();
    }
    private String[][] getProperty(Object obj) {
        ArrayList<String> row = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();
        Class<?> clz = obj.getClass();
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            String value = "'%s'";
            try {
                value = String.format(value, field.get(obj).toString());
            } catch (Exception e) {
                continue;
            }
            String property = fields[i].getName();
            row.add(property);
            values.add(value);
        }
        return new String[][]{row.toArray(new String[0]), values.toArray(new String[0])};
    }

    //关闭资源的方法
    public void close() {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized int executeInsert() {
        String[][] property = getProperty(this.obj);
        String columnArg = montageWithComma(property[0]);
        String valueArg = montageWithComma(property[1]);
        String sql = "INSERT INTO " + this.clzName + " ( " + columnArg + " ) VALUES ( " + valueArg + " ) ";
        try {
            ps = conn.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public synchronized int executeDelete() {
        String[][] property = getProperty(this.obj);
        String arg = montageWithEqualSign(property);
        String sql = "DELETE FROM " + this.clzName + " WHERE " + arg + " ; ";
        try {
            ps = conn.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public synchronized int executeUpdate(Object vluObj) {
        String[][] vluProperty = getProperty(vluObj);
        String[][] condProperty = getProperty(this.obj);
        String vluArg = montageWithEqualSign(vluProperty);
        String condArg = montageWithEqualSign(condProperty);
        String sql = "UPDATE " + this.clzName + " SET " +vluArg + " WHERE " + condArg + " ; ";
        try {
            ps = conn.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // 查询
    public synchronized ResultSet executeQuery() {
        String sql = "SELECT * FROM " + this.clzName;
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
        } catch (Exception e) {
            return null;
        }
        return rs;
    }
}
