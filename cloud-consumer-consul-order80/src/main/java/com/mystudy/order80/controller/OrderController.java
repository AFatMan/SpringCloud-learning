package com.mystudy.order80.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 刘健生
 * @Date 2021-03-12 14:12
 * @Description
 */
@RestController
public class OrderController {

    private final String invoke_url = "http://cloud-payment-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/order/consul/getPayment")
    @ResponseBody
    public String getPaymentByConsul(){

        return restTemplate.getForObject(invoke_url+"/payment/consul",String.class);
    }

}
