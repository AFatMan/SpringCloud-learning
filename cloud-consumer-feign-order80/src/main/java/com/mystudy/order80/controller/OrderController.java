package com.mystudy.order80.controller;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.order80.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘健生
 * @Date 2021-03-12 17:58
 * @Description
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/feign/payment/get/{id}")
    public CommonResult<Payment> getPaymentByFeign(@PathVariable("id") Long id){
        return paymentFeignService.getPayment(id);
    }

    /**
     * openfeign默认超时时间为1秒
     * @return
     */
    @GetMapping("/consumer/feign/payment/timeout")
    public String getPaymentByFeignTimeOut(){
        return paymentFeignService.getPaymentTimeOut();
    }
}
