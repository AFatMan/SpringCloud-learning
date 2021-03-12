package com.mystudy.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-12 10:00
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerZkOrder {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZkOrder.class,args);
    }

}
