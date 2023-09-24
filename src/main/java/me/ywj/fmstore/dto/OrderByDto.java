package me.ywj.fmstore.dto;

import lombok.Getter;

@Getter
public class OrderByDto {
    private final String property;
    private final boolean desc;

    public OrderByDto(String property, boolean desc) {
        this.property = property;
        this.desc = desc;
    }
}
