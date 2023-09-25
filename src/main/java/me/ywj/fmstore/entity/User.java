package me.ywj.fmstore.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    Long id;
    String username;
    String password;
    Integer type;
    Long reg_time;

    public User() {
    }

    public User(Long id, String username, String password, Integer type, Long reg_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.reg_time = reg_time;
    }
}
