package com.mystudy.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-25 16:09
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.mystudy.order.dao")
public class SeataOrderService2001 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderService2001.class,args);
    }
}
