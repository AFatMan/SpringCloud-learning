package com.mystudy.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author 刘健生
 * @Date 2021-03-10 17:18
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient //标注为eureka客户端,提供或消费服务
public class OrderMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
