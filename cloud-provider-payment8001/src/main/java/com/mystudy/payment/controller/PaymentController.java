package com.mystudy.payment.controller;

import com.mystudy.payment.entity.CommonResult;
import com.mystudy.payment.entity.Payment;
import com.mystudy.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘健生
 * @Date 2021-03-10 16:04
 * @Description
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/save")
    public CommonResult<Payment> save(Payment payment) {
        if (paymentService.save(payment)) {
            return new CommonResult<>(200, "添加用户成功");
        } else {
            return new CommonResult<>(500, "添加用户失败");
        }
    }

    @GetMapping("/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        if (paymentService.save(payment)) {
            return new CommonResult<>(200, "添加用户成功");
        } else {
            return new CommonResult<>(500, "添加用户失败");
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        Payment byId = paymentService.getById(id);
        return new CommonResult<>(200, "查询用户成功", byId);
    }


}
