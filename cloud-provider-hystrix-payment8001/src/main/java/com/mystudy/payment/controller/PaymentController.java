package com.mystudy.payment.controller;

import com.mystudy.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘健生
 * @Date 2021-03-15 14:36
 * @Description
 */
@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String servicePort;

    // 正常访问
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentService.getPaymentInfo_OK(id);
    }

    // 超时访问
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        return paymentService.getPaymentInfo_TimeOut(id);

    }

    //====服务熔断
    @GetMapping("/payment/hystrix/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        return paymentService.paymentCircuitBreaker(id);
    }
}
