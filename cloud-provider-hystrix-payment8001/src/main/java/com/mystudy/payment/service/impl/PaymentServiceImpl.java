package com.mystudy.payment.service.impl;

import com.mystudy.payment.service.PaymentService;
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
        return "当前程序名:"+Thread.currentThread().getName()+"   getPaymentInfo_OK(id="+i+")     ";
    }

    @Override
    public String getPaymentInfo_TimeOut(Integer i) {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "当前程序名:"+Thread.currentThread().getName()+"   getPaymentInfo_TimeOut(id="+i+")     ";
    }
}
