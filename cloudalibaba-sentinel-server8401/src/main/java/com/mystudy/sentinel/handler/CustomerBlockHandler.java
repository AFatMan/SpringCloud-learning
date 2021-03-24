package com.mystudy.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.mystudy.cloudapicommon.entity.CommonResult;

/**
 * 自定义限流处理类
 * @Author 刘健生
 * @Date 2021-03-24 14:21
 * @Description
 */
public class CustomerBlockHandler {
    public static CommonResult handlerException(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }

    public static CommonResult handlerException2(BlockException exception) {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}

