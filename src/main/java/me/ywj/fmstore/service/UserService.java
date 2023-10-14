package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.UserDao;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.entity.User;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.util.JWTUtil;
import me.ywj.fmstore.vo.UserVo;

import java.util.Date;

public class UserService {
    public static String reg(UserDto userDto){
        User user = (User) ConvertUtil.dtoToEntity(userDto);
        user.setReg_time(new Date().getTime());
        if(UserDao.insert(user) == 1){
            return JWTUtil.generateToken(user);
        }else {
            return null;
        }
    }
    public static String login(UserDto userDto){
        User userQuery = new User();
        userQuery.setUsername(userDto.getUsername());
        User res = UserDao.query(userQuery);
        if(res.getPassword().equals(userDto.getPassword())){
            return JWTUtil.generateToken(res);
        }
        else {
            return null;
        }
    }
}
