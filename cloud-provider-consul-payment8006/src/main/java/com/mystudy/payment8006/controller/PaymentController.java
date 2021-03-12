package com.mystudy.payment8006.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Author 刘健生
 * @Date 2021-03-12 11:11
 * @Description
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    @ResponseBody
    public String zk(){
        return "SpringCloud with Consul:" + port + "\t" + UUID.randomUUID().toString();
    }
}
