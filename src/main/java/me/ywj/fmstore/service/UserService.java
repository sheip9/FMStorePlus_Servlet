package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.UserDao;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.pojo.User;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.util.JWTUtil;

import java.util.HashMap;

/**
 * 
 * 
 * @author sheip9
 */
public class UserService {
    public static String register(UserDto userDto){
        User user = (User) ConvertUtil.dtoToEntity(userDto);
        user.setReg_time(System.currentTimeMillis());
        if(UserDao.insert(user) == 1){
            return generateToken(user);
        }else {
            return null;
        }
    }
    public static String login(UserDto userDto) throws Exception {
        User userQuery = new User();
        userQuery.setUsername(userDto.getUsername());
        User res = UserDao.query(userQuery);
        if(res.getPassword().equals(userDto.getPassword())){
            return generateToken(res);
        }
        else {
            throw new Exception(userDto.getUsername() + "密码错误。");
        }
    }
    private static String generateToken(User user){
        HashMap<String, String> map = new HashMap<>();
        map.put("username", user.getUsername());
        return JWTUtil.generateToken(map);
    }
    public static Long getUserId(String username){
        User user = new User();
        user.setUsername(username);
        User res = UserDao.query(user);
        return user.getId();
    }
}
