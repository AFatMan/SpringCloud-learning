package com.mystudy.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author 刘健生
 * @Date 2021-03-11 16:58
 * @Description
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced //集群 负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
