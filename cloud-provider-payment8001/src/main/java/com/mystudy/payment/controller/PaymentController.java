package com.mystudy.payment.controller;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 服务发现,搭配@EnableDiscoveryClient使用
     */
    @Autowired
    private DiscoveryClient discoveryClient;

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
     * 查找注册到eureka上的服务
     * @return
     */
    @GetMapping("/payment/discovery")
    public CommonResult discoveryClient(){
        ArrayList<Object> objects = new ArrayList<>();
        // 获取所有微服务名称
        List<String> services = discoveryClient.getServices();

        // 获取某个微服务下所有实例
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        objects.add(services);
        objects.add(instances);
        return new CommonResult<>(200,"ok",objects);
    }

    /**
     * 手写轮询规则
     * @return
     */
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;//返回服务接口
    }

    /**
     * 测试超时连接
     * @return
     */
    @GetMapping(value = "/payment/timeOut")
    public String getPaymentTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;//返回服务接口
    }

    /**
     * 测试sleuth链路追踪
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi ,i'am paymentzipkin server fall back，welcome to here, O(∩_∩)O哈哈~";
    }
}
