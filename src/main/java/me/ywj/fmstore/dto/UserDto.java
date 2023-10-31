package me.ywj.fmstore.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class UserDto {
    String username;
    String password;

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
