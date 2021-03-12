package com.mystudy.payment8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-12 09:03
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderPayment8004 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8004.class,args);
    }
}
