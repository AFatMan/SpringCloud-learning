package com.mystudy.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 刘健生
 * @Date 2021-03-23 17:13
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AliSentinelServer8401 {
    public static void main(String[] args) {
        SpringApplication.run(AliSentinelServer8401.class, args);
    }
}
