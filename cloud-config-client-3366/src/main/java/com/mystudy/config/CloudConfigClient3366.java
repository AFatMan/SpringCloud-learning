package com.mystudy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 刘健生
 * @Date 2021-03-19 14:49
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient3366 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigClient3366.class,args);
    }
}
