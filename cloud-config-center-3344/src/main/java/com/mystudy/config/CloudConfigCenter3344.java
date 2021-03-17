package com.mystudy.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置读取规则
 *
 *  /{label}/{application}-{profile}.yml（推荐）
 *      master分支
 *          http://config-3344.com:3344/master/config-dev.yml
 *          http://config-3344.com:3344/master/config-test.yml
 *          http://config-3344.com:3344/master/config-prod.yml
 *      dev分支
 *          http://config-3344.com:3344/dev/config-dev.yml
 *          http://config-3344.com:3344/dev/config-test.yml
 *          http://config-3344.com:3344/dev/config-prod.yml
 *
 *  /{application}-{profile}.yml
 *      http://config-3344.com:3344/config-dev.yml
 *      http://config-3344.com:3344/config-test.yml
 *      http://config-3344.com:3344/config-prod.yml
 *      http://config-3344.com:3344/config-xxxx.yml(不存在的配置)
 *
 *  /{application}/{profile}[/{label}]
 *      http://config-3344.com:3344/config/dev/master
 *      http://config-3344.com:3344/config/test/master
 *      http://config-3344.com:3344/config/test/dev
 *
 * 重要配置细节总结
 *      /{name}-{profiles}.yml
 *      /{label}-{name}-{profiles}.yml
 *      label：分支(branch)
 *      name：服务名
 *      profiles：环境(dev/test/prod)
 *
 * @Author 刘健生
 * @Date 2021-03-17 16:32
 * @Description
 */
@SpringBootApplication
@EnableEurekaClient // 注册服务
@EnableConfigServer //标注为配置中心
public class CloudConfigCenter3344 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigCenter3344.class,args);
    }
}
