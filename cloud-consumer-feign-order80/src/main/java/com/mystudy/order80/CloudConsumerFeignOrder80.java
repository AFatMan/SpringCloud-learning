package com.mystudy.order80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author 刘健生
 * @Date 2021-03-12 17:57
 * @Description
 */
@SpringBootApplication
@EnableFeignClients //标注为feign客户端
public class CloudConsumerFeignOrder80 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFeignOrder80.class,args);
    }
}
