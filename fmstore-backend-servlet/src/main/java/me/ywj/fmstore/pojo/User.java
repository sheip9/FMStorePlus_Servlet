package me.ywj.fmstore.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    Long id;
    String username;
    String password;
    Integer type;
    Long reg_time;

    public User(Long id, String username, String password, Integer type, Long reg_time) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.type = type;
        this.reg_time = reg_time;
    }
}
