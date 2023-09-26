package me.ywj.fmstore.service;

import me.ywj.fmstore.dao.UserDao;
import me.ywj.fmstore.dto.UserDto;
import me.ywj.fmstore.entity.User;
import me.ywj.fmstore.util.ConvertUtil;
import me.ywj.fmstore.util.JWTUtil;
import me.ywj.fmstore.vo.UserVo;

import java.util.Date;

public class UserService {
    public static UserVo reg(UserDto userDto){
        User user = (User) ConvertUtil.dtoToEntity(userDto);
        user.setReg_time(new Date().getTime());
        if(UserDao.insert(user) == 1){
            UserVo userVo = ConvertUtil.entityToVo(user);
            userVo.setToken(JWTUtil.generateToken(user));
            return userVo;
        }else {
            return null;
        }
    }
    public static UserVo login(UserDto userDto){
        User userQuery = new User();
        userQuery.setUsername(userDto.getUsername());
        User res = UserDao.query(userQuery);
        if(res.getPassword().equals(userDto.getPassword())){
            UserVo userVo = new UserVo();
            userVo.setUsername(userDto.getUsername());
            userVo.setToken(JWTUtil.generateToken(userQuery));
            return userVo;
        }
        else {
            return null;
        }
    }
}
