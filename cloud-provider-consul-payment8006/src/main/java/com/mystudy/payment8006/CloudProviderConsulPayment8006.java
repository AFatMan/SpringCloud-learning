package com.mystudy.payment8006;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * consul:window端下载只有一个exe文件,在exe文件位置打开cmd,
 *  命令:
 *      consul --version; 查看版本
 *      consul agent -dev: 开发模式启动consul,默认web页面是 http://localhost:8500
 * @Author 刘健生
 * @Date 2021-03-12 11:05
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudProviderConsulPayment8006 {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderConsulPayment8006.class,args);
    }
}
