package com.mystudy.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-24 15:06
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliProviderPayment9003 {

    public static void main(String[] args) {
        SpringApplication.run(AliProviderPayment9003.class,args);
    }

}
