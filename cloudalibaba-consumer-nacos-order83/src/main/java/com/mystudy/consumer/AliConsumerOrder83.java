package com.mystudy.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-22 17:52
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliConsumerOrder83 {

    public static void main(String[] args) {
        SpringApplication.run(AliConsumerOrder83.class,args);
    }
}
