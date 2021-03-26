package com.mystudy.account.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * seata接管数据源
 * @Author 刘健生
 * @Date 2021-03-26 11:45
 * @Description
 */
@Configuration
// @EnableConfigurationProperties({MybatisPlusProperties.class})
public class DataSourceConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        return new DataSourceProxy(dataSource);
    }

    /*@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSourceProxy dataSourceProxy, MybatisPlusProperties mybatisPlusProperties) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSourceProxy);

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] mapperLocaltions = resolver.getResources(mybatisPlusProperties.getMapperLocations()[0]);
            bean.setMapperLocations(mapperLocaltions);

            if (StringUtils.isNotBlank(mybatisPlusProperties.getConfigLocation())) {
                Resource[] resources = resolver.getResources(mybatisPlusProperties.getConfigLocation());
                bean.setConfigLocation(resources[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bean;
    }*/

    @Bean
    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean(DataSourceProxy dataSourceProxy) {
        // 这里用 MybatisSqlSessionFactoryBean 代替了 SqlSessionFactoryBean，否则 MyBatisPlus 不会生效
        MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        mybatisSqlSessionFactoryBean.setDataSource(dataSourceProxy);

        /*ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] mapperLocaltions = resolver.getResources(mybatisPlusProperties.getMapperLocations()[0]);
            mybatisSqlSessionFactoryBean.setMapperLocations(mapperLocaltions);

            if (StringUtils.isNotBlank(mybatisPlusProperties.getConfigLocation())) {
                Resource[] resources = resolver.getResources(mybatisPlusProperties.getConfigLocation());
                mybatisSqlSessionFactoryBean.setConfigLocation(resources[0]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        return mybatisSqlSessionFactoryBean;
    }
}
