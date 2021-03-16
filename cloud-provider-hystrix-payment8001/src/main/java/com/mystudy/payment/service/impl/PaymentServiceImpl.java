package com.mystudy.payment.service.impl;

import cn.hutool.core.util.IdUtil;
import com.mystudy.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * HystrixCommandProperties里记载了HystrixCommand注解常用的配置项
 * @Author 刘健生
 * @Date 2021-03-15 14:33
 * @Description
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String getPaymentInfo_OK(Integer i) {
        return "当前程序名:" + Thread.currentThread().getName() + "   getPaymentInfo_OK(id=" + i + ")     ";
    }

    @HystrixCommand(
            // 当调用此方法发生服务降级时,兜底方法的方法名
            fallbackMethod = "fallbackGetPaymentInfo_TimeOut",
            commandProperties = {
                // 超时时间
                @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")}
    )
    @Override
    public String getPaymentInfo_TimeOut(Integer i) {
        try {
            // int age = 1/0;
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前程序名:" + Thread.currentThread().getName() + "   getPaymentInfo_TimeOut(id=" + i + ")     ";
    }

    /**
     * 兜底方法 服务降级后调用此方法,除了方法名可以不一致,其他必须与发生降级的方法保持一致(参数,返回类型,权限修饰等)
     *
     * @param i
     * @return
     */
    public String fallbackGetPaymentInfo_TimeOut(Integer i) {
        return "服务降级: 系统繁忙!!!^(*￣(oo)￣)^ ";
    }


    //=====服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//默认=>20 在统计数据起作用之前，必须在10秒内发生10个请求
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //默认=> 5000 = 5秒，在跳闸电路后和再次尝试之前进入睡眠状态,睡五秒
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 默认值=> errorThresholdPercentage = 50 =如果10秒内50％+的请求失败或潜在，则我们将使电路跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
