package com.mystudy.payment;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @Author 刘健生
 * @Date 2021-03-15 14:31
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker //断路器,
public class CloudProviderHystrixPayment8001 {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrixPayment8001.class,args);
    }


    /**
     * 方式一: ---- 监控页监控地址-->http://localhost:8001/hystrix.stream
     *  此配置是为了服务监控而配置，与服务容错本身无关，springCloud 升级之后的坑
     *  ServletRegistrationBean因为springboot的默认路径不是/hystrix.stream
     *  只要在自己的项目中配置上下面的servlet即可
     * 方式二:官网推荐配置 ---- 监控页监控地址-->http://localhost:8001/actuator/hystrix.stream
     *  management:
     *   endpoints:
     *     web:
     *       exposure:
     *         include: "*"
     * @return
     */
    // @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean<HystrixMetricsStreamServlet> registrationBean = new ServletRegistrationBean<>(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }

}
