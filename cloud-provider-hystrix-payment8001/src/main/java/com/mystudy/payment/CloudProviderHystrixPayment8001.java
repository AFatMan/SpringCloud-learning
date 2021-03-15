package com.mystudy.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 刘健生
 * @Date 2021-03-15 14:31
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //断路器,
public class CloudProviderHystrixPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001.class,args);
    }
}
