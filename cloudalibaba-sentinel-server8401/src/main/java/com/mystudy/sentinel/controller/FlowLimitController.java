package com.mystudy.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘健生
 * @Date 2021-03-23 17:21
 * @Description
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...testB");
        return "------testB";
    }

    @GetMapping("/testHotKey")
    /*
    value->唯一标识
    fallback：失败调用，若本接口出现未知异常，则调用fallback指定的接口。
    blockHandler：sentinel定义的失败调用或限制调用，若本次访问被限流或服务降级，则调用blockHandler指定的接口。
     */
    @SentinelResource(value = "testHotKey",blockHandler = "dealTestHotKey")
    public String testHotKey(@RequestParam(value = "param1",required = false) String param1,
                             @RequestParam(value = "param2",required = false) String param2) {
        log.info(Thread.currentThread().getName() + "\t" + "...testHotKey");
        return "------testHotKey";
    }

    public String dealTestHotKey(String param1, String param2, BlockException blockException){
        return "testHotKey方法发生限流,由我来处理";
    }
}

