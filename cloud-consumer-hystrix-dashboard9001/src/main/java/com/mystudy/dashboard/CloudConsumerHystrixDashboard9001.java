package com.mystudy.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @Author 刘健生
 * @Date 2021-03-16 14:52
 * @Description
 */
@SpringBootApplication
@EnableHystrixDashboard // 监控地址:http://localhost:9001/hystrix 需要监控的项目引入actuator
public class CloudConsumerHystrixDashboard9001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerHystrixDashboard9001.class,args);
    }

}
