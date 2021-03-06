package com.mystudy.order.controller;

import com.mystudy.cloudapicommon.entity.CommonResult;
import com.mystudy.cloudapicommon.entity.Payment;
import com.mystudy.order.lb.LoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @Author 刘健生
 * @Date 2021-03-10 17:58
 * @Description
 */
@Controller
public class OrderConsumerController {

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    /*
    单机eureka版:可使用ip地址加端口写死
     */
    // private final String CLOUD_PAYMENT_SERVICE = "http://localhost:8001/";
    // 集群后通过微服务名称调用相关类,需要配合@LoadBalanced注解提供负载均衡功能
    private final String CLOUD_PAYMENT_SERVICE = "http://CLOUD-PAYMENT-SERVICE/";

    private final String URL_GET_PAYMENT = CLOUD_PAYMENT_SERVICE+"payment/get/";
    private final String URL_CREATE_PAYMENT = CLOUD_PAYMENT_SERVICE + "payment/create";

    @Autowired
    RestTemplate restTemplate;

    /**
     * getForObject()：返回对象为响应体中数据转化成的对象，基本上可以理解为Json。
     *
     * getForEntity()：返回对象为ResponseEntity对象，包含了响应中的一些重要信息，比如响应头、响应状态码、响应体等。
     * @param id
     * @return
     */
    @GetMapping("/order/consumer/getPayment/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentFromPaymentService(@PathVariable("id") Long id){

        return restTemplate.getForObject(URL_GET_PAYMENT +id, CommonResult.class);
    }

    @GetMapping("/order/consumer/getPaymentByEntity/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentFromPaymentServiceByEntity(@PathVariable("id") Long id){

        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(URL_GET_PAYMENT + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return new CommonResult<>(500,"请求失败");
        }

    }

    @GetMapping("/order/consumer/createPayment")
    @ResponseBody
    public CommonResult savePaymentFromPaymentService(Payment payment){
        return restTemplate.postForObject(URL_CREATE_PAYMENT,payment ,CommonResult.class);
    }

    /**
     * 测试手写轮询规则
     * @return
     */
    @GetMapping(value = "/consumer/payment/lb")
    @ResponseBody
    public String getPaymentLB()
    {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        if(instances == null || instances.size() <= 0){
            return null;
        }

        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);

    }

    /**
     * 测试sleuth链路追踪
     * @return
     */
    @GetMapping("/consumer/payment/zipkin")
    @ResponseBody
    public String paymentZipkin()
    {
        String result = restTemplate.getForObject(CLOUD_PAYMENT_SERVICE+"/payment/zipkin/", String.class);
        return result;
    }
}
