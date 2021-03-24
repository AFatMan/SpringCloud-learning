package com.mystudy.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-24 15:12
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliProviderPayment9004 {

    public static void main(String[] args) {
        SpringApplication.run(AliProviderPayment9004.class,args);
    }

}
