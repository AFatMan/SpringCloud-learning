package com.mystudy.order.service.impl;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.order.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @Author 刘健生
 * @Date 2021-03-24 16:27
 * @Description
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(500,"PaymentServiceImpl降级处理");
    }
}
