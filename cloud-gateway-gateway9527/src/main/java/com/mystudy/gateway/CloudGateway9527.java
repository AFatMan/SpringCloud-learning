package com.mystudy.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 常用的Route Predicate Factory
 *      The After Route Predicate Factory
 *      The Before Route Predicate Factory
 *      The Between Route Predicate Factory
 *      The Cookie Route Predicate Factory
 *      The Header Route Predicate Factory
 *      The Host Route Predicate Factory
 *      The Method Route Predicate Factory
 *      The Path Route Predicate Factory
 *      The Query Route Predicate Factory
 *      The RemoteAddr Route Predicate Factory
 *      The weight Route Predicate Factory
 *
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
