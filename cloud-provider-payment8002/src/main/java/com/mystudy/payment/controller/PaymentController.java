package com.mystudy.payment.controller;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author 刘健生
 * @Date 2021-03-10 16:04
 * @Description
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment) {
        if (paymentService.save(payment)) {
            return new CommonResult<>(200, "添加用户成功,server端口:"+serverPort);
        } else {
            return new CommonResult<>(500, "添加用户失败,server端口:"+serverPort);
        }
    }

    @RequestMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        if (paymentService.save(payment)) {
            return new CommonResult<>(200, "添加用户成功,server端口:"+serverPort,payment);
        } else {
            return new CommonResult<>(500, "添加用户失败,server端口:"+serverPort);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment byId = paymentService.getById(id);
        return new CommonResult<>(200, "查询用户成功,server端口:"+serverPort, byId);
    }

    /**
     * 手写轮询规则
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }

}
