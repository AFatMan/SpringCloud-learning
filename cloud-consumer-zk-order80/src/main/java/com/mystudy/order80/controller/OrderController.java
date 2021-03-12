package com.mystudy.order80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 刘健生
 * @Date 2021-03-12 10:09
 * @Description
 */
@Controller
public class OrderController {

    private final String invoke_url = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/order/zk/getPayment")
    @ResponseBody
    public String getPaymentByZk(){

        return restTemplate.getForObject(invoke_url+"/payment/zk",String.class);
    }


}
