package com.mystudy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 刘健生
 * @Date 2021-03-16 16:41
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudGateway9527 {

    public static void main(String[] args) {
        SpringApplication.run(CloudGateway9527.class,args);
    }

}
