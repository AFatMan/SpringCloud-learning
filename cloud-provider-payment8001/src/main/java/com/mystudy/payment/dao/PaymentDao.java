package com.mystudy.payment.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mystudy.cloudapicommon.entity.Payment;

/**
 * @Author 刘健生
 * @Date 2021-03-10 15:59
 * @Description
 */
public interface PaymentDao extends BaseMapper<Payment> {


    int create(Payment payment);
}
