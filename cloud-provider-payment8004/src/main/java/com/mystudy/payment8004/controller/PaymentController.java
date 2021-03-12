package com.mystudy.payment8004.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @Author 刘健生
 * @Date 2021-03-12 09:18
 * @Description
 */
@Controller
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/zk")
    @ResponseBody
    public String zk(){
        return "SpringCloud with zookeeper:" + port + "\t" + UUID.randomUUID().toString();
    }

}
