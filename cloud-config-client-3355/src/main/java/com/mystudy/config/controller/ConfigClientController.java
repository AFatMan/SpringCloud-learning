package com.mystudy.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试:
 *  启动Config配置中心3344微服务并自测
 *      http://config-3344.com:3344/main/config-prod.yml
 *      http://config-3344.com:3344/main/config-dev.yml
 *
 *  启动3355作为Client准备访问
 *      http://localhost:3355/configInfo
 *
 * @Author 刘健生
 * @Date 2021-03-17 18:11
 * @Description
 */
@RestController
public class ConfigClientController
{
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo()
    {
        return configInfo;
    }
}