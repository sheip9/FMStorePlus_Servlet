package me.ywj.fmstore.dao;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * MyDao
 *
 * @author sheip9
 * @since 2023/12/27 19:27
 */
public class MyDao <E> {
    public <T> List<T> listAs(PreparedStatement ps, Class<T> clazz){
        List<T> list = new ArrayList<>();
        try {
            Field[] fields = clazz.getDeclaredFields();
            Class<?>[] filedTypes = new Class[fields.length];
            for (int i = 0; i < fields.length; i++) {
                filedTypes[i] = fields[i].getType();
            }
            Constructor<T> constructor = clazz.getDeclaredConstructor(filedTypes);
            Object[] values = new Object[fields.length];
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                T t;

                //TODO: 类型还不能直接转换，若数据库字段类型和类的属性不一致会导致异常
                for (int i = 0; i < fields.length; i++) {
                    values[i] = rs.getObject(i + 1);
                }

                t = constructor.newInstance(values);
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
