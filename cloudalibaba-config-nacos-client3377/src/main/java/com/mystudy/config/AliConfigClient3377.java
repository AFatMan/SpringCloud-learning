package com.mystudy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-23 09:13
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliConfigClient3377 {

    public static void main(String[] args) {
        SpringApplication.run(AliConfigClient3377.class,args);
    }

}
