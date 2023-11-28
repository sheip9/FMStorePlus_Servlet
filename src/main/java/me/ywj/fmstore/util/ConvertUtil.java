package me.ywj.fmstore.util;

import me.ywj.fmstore.dto.ItemDto;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.pojo.Item;
import me.ywj.fmstore.pojo.User;
import me.ywj.fmstore.vo.ItemVo;
import me.ywj.fmstore.vo.UserVo;
import org.apache.commons.beanutils.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConvertUtil {
    private static final HashMap<Class<?>,Class<?>> entityMap = new HashMap<>();
    static {
        entityMap.put(ItemDto.class, Item.class);
        entityMap.put(Item.class, ItemVo.class);
        entityMap.put(UserDto.class, User.class);
    }
    /**
     * 对象的转换
     * @param origObj 原始对象
     * @param destClass 目标类
     * @return 目标对象
     */

    private static <T> T objConvert(Object origObj, Class<T> destClass) {
        if (origObj == null || destClass == null) {
            return null;
        }
        T destObj = null;
        try {
            // 创建新的对象实例
            destObj = destClass.newInstance();
            // 把原对象数据拷贝到新的对象
            BeanUtils.copyProperties(destObj,origObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destObj;
    }

    /***
     * 列表内的对象的转换
     * @param origList 原始对象的列表
     * @param destClass 目标类
     * @return 目标对象的列表
     */
    private static <T> List<T> listConvert(List<?> origList, Class<T> destClass){
        if (origList == null) {
            return null;
        }
        List<T> destList = new ArrayList<>(origList.size());
        try {
            for (Object origObj : origList) {
                T targetObject = objConvert(origObj, destClass);
                destList.add(targetObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destList;
    }
    public static Object dtoToEntity(Object dto) {
        return objConvert(dto,  entityMap.get(dto.getClass()));
    }
    public static <T> List<T> entityListToVoList(List<?> origList, Class<T> destClass){
        return listConvert(origList, destClass);
    }
    public static UserVo entityToVo(User user){
        return objConvert(user, UserVo.class);
    }
}
