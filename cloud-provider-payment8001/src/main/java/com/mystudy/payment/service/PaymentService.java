package com.mystudy.payment.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.payment.dao.PaymentDao;

/**
 * @Author 刘健生
 * @Date 2021-03-10 16:02
 * @Description
 */
public interface PaymentService extends IService<Payment> {

    int create(Payment payment);
}
