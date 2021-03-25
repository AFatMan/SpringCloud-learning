package com.mystudy.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:22
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.mystudy.account.dao")
public class SeataAccountService2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountService2003.class,args);
    }
}
