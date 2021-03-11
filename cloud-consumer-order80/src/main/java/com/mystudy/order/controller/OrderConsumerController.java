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

    /*
    单机eureka版:可使用ip地址加端口写死
     */
    // private final String CLOUD_PAYMENT_SERVICE = "http://localhost:8001/";
    // 集群后通过微服务名称调用相关类,需要配合@LoadBalanced注解提供负载均衡功能
    private final String CLOUD_PAYMENT_SERVICE = "http://CLOUD-PAYMENT-SERVICE/";

    private final String URL_GET_PAYMENT = CLOUD_PAYMENT_SERVICE+"payment/get/";
    private final String URL_CREATE_PAYMENT = CLOUD_PAYMENT_SERVICE + "payment/create";

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
