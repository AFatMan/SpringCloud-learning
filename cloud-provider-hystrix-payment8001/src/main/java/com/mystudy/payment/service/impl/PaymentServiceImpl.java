package com.mystudy.payment.service.impl;

import com.mystudy.payment.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
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
            // 当调用此方法发生服务熔断时,兜底方法的方法名
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
     * 兜底方法 服务熔断后调用此方法,除了方法名可以不一致,其他必须与发生熔断的方法保持一致(参数,返回类型,权限修饰等)
     *
     * @param i
     * @return
     */
    public String fallbackGetPaymentInfo_TimeOut(Integer i) {
        return "服务熔断: 系统繁忙!!!^(*￣(oo)￣)^ ";
    }
}
