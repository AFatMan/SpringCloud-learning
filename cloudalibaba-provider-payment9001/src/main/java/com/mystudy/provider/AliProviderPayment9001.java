package com.mystudy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-22 17:20
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliProviderPayment9001 {

    public static void main(String[] args) {
        SpringApplication.run(AliProviderPayment9001.class,args);
    }

}
