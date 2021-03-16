package com.mystudy.order80.service;

import org.springframework.stereotype.Service;

/**
 * 当controller没有添加@HystrixCommand熔断、服务降级注解
 *      调用PaymentHystrixService的方法异常时,可以直接使用PaymentFallbackService里定义的兜底方法,
 * @Author 刘健生
 * @Date 2021-03-16 10:08
 * @Description
 */
@Service
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentHystrixService:paymentInfo_OK:服务降级";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentHystrixService:paymentInfo_TimeOut:服务降级";
    }
}
