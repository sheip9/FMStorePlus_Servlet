package me.ywj.fmstore.dto;

import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
@Getter
public class OrderByGroupDto {
    private final OrderByDto[] orderBy;

    public OrderByGroupDto(Class<?> clazz,OrderByDto[] orderBy) {
        Field[] fields = clazz.getDeclaredFields();
        ArrayList<String> fieldsNames = new ArrayList<>();
        for (Field field : fields) {
            fieldsNames.add(field.getName());
        }
        for (OrderByDto orderByDto : orderBy) {
            if(!fieldsNames.contains(orderByDto.getProperty())){

            }
        }
        this.orderBy = orderBy;
    }
}
