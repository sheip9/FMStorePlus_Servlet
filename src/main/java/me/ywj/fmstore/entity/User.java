package me.ywj.fmstore.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
