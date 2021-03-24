package com.mystudy.order.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @Author 刘健生
 * @Date 2021-03-24 15:19
 * @Description
 */
@RestController
public class CircleBreakController {
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Resource
    private RestTemplate restTemplate;
}
