package com.mystudy.cloudapicommon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 刘健生
 * @Date 2021-03-10 15:56
 * @Description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(int code, String message) {
        this(code,message,null);
    }
}
