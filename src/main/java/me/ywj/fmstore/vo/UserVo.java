package me.ywj.fmstore.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
public class UserVo {
    String username;
    String password;
    public UserVo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
