package com.mystudy.order80.controller;

import com.mystudy.order80.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 刘健生
 * @Date 2021-03-15 15:51
 * @Description
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback") // 配置全局服务降级
public class OrderController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("consumer/payment/hystrix/ok/{id}")
    public String ok(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_OK(id);
    }


    // 使用全局服务降级
    // @HystrixCommand(
    //         // 当调用此方法发生服务熔断时,兜底方法的方法名
    //         fallbackMethod = "fallbackTimeOut",
    //         commandProperties = {
    //                 // 超时时间
    //                 @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")}
    // )
    @HystrixCommand
    @GetMapping("consumer/payment/hystrix/timeout/{id}")
    public String timeOut(@PathVariable("id") Integer id) {
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String fallbackTimeOut(Integer id) {
        return "服务降级: 系统繁忙!!!^(*￣(oo)￣)^ ";
    }

    /**
     * 全局降级方法,与业务逻辑混杂,有待改进
     * @return
     */
    public String defaultFallback() {
        return "OrderController全局兜底:系统繁忙!!!^(*￣(oo)￣)^ ";
    }
}
