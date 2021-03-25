package com.mystudy.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-25 18:05
 * @Description
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.mystudy.storage.dao")
public class SeataStorageService2002 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageService2002.class,args);
    }

}
