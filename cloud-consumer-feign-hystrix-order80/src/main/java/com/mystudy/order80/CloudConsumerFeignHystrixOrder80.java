package com.mystudy.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-15 15:50
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerFeignHystrixOrder80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignHystrixOrder80.class,args);
    }
}
