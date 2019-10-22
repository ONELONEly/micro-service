package com.yhm.microserviceclient.base.common.config.dataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean("druidDataSourceProperties_defult")
    @ConfigurationProperties("spring.datasource.druid")
    public DruidDataSourceProperties druidDataSourceProperties_defult(){
        return new DruidDataSourceProperties();
    }


    @Bean(name="ora8_ds")
    @ConfigurationProperties("spring.datasource.druid.ora8")
    public DataSource dataSource_ora8(){
        return createDataSource(druidDataSourceProperties_defult());
    }

    @Bean(name="ssaln_ds")
    @ConfigurationProperties("spring.datasource.druid.ssaln")
    public DataSource dataSource_ssaln(){
        return createDataSource(druidDataSourceProperties_defult());
    }


    private DataSource createDataSource(DruidDataSourceProperties properties){
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        build.configFromPropety(properties.toProperties());
        build.setConnectProperties(properties.getConnectionProperties());
        return build;
    }
}
