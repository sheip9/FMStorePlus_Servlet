package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.UserDao;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.entity.User;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.vo.UserVo;

public class UserService {
    public static void reg(UserDto userDto){
        User user = (User) ConvertUtil.dtoToEntity(userDto);
        UserDao.insert(user);
    }
    public static void login(UserDto userDto){

    }
}
