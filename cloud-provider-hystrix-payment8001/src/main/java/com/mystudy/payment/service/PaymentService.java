package com.mystudy.payment.service;

/**
 * @Author 刘健生
 * @Date 2021-03-15 14:33
 * @Description
 */
public interface PaymentService {
    String getPaymentInfo_OK(Integer i);
    String getPaymentInfo_TimeOut(Integer i);
    String paymentCircuitBreaker(Integer id) ;
}
