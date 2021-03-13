package com.mystudy.order80.service;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @Author 刘健生
 * @Date 2021-03-12 17:58
 * @Description
 */
@Component
@FeignClient(value = "cloud-payment-service")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{id}") // 请求地址需要给服务提供方一致;
    CommonResult<Payment> getPayment(@PathVariable("id") Long id) ;

    @GetMapping(value = "/payment/timeOut")
    String getPaymentTimeOut() ;
}
