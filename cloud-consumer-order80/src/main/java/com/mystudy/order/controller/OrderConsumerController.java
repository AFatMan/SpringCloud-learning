package com.mystudy.order.controller;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 刘健生
 * @Date 2021-03-10 17:58
 * @Description
 */
@Controller
public class OrderConsumerController {

    private final String URL_GET_PAYMENT = "http://localhost:8001/payment/get/";
    private final String URL_CREATE_PAYMENT = "http://localhost:8001/payment/create";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/order/consumer/getPayment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentFromPaymentService(@PathVariable("id") Long id){

        return restTemplate.getForObject(URL_GET_PAYMENT +id, CommonResult.class);
    }

    @GetMapping("/order/consumer/createPayment")
    @ResponseBody
    public CommonResult savePaymentFromPaymentService(Payment payment){
        return restTemplate.postForObject(URL_CREATE_PAYMENT,payment ,CommonResult.class);
    }
}
