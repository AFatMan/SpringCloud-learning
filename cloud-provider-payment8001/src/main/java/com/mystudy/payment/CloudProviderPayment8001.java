package com.mystudy.payment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 刘健生
 * @Date 2021-03-10 15:35
 * @Description
 */
@MapperScan("com.mystudy.payment.dao")
@EnableDiscoveryClient //让注册中心能够发现，扫描到该服务。
@EnableEurekaClient //标注为eureka客户端,提供或消费服务
@SpringBootApplication
public class CloudProviderPayment8001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment8001.class,args);
    }
}
