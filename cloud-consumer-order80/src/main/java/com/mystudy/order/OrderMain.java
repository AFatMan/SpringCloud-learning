package com.mystudy.order;

import com.mystudy.order.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author 刘健生
 * @Date 2021-03-10 17:18
 * @Description
 */
@SpringBootApplication
//ribbon官方推荐不能被ComponentScan扫描到,否则定制化规则将应用于所有ribbon客户端,方法1,排除规则类,方法2,在主启动类所在包外建规则类
@ComponentScan(excludeFilters ={@ComponentScan.Filter(type = FilterType.REGEX,pattern = "com.mystudy.order.rule.*")} )
//配置负载均衡客户端的规则
// @RibbonClient(name="cloud-payment-service",configuration = MyRule.class)  //手写轮询规则
@EnableEurekaClient //标注为eureka客户端,提供或消费服务
public class OrderMain {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
