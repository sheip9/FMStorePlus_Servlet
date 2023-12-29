package me.ywj.fmstore.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * RestResponse
 *
 * @author sheip9
 * @since 2023/12/28 16:28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse <T> {
    int code;
    String message;
    T data;

    public RestResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
