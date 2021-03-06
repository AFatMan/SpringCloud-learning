package com.mystudy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-24 15:01
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AliConsumerOrder84 {
    public static void main(String[] args) {
        SpringApplication.run(AliConsumerOrder84.class, args);
    }
}
