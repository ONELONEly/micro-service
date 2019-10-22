package com.yhm.microserviceclient.base.common.config.mybatis;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class SqlSessionFactoryConfiguration {

    /*@Bean("mybatisPlusProperties_defult")
    @ConfigurationProperties("mybatis-plus")
    public MybatisPlusProperties mybatisPlusProperties_defult(){
        return new MybatisPlusProperties();
    }*/



    /*@Bean(name = "ora8_sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(
            @Qualifier("ora8_ds") DataSource dataSource) throws Exception {
        String mapperLocations = "classpath:mapper/primary/*.xml";
        String configLocation = "classpath:mybatis-sqlconfig.xml";
        String typeAliasesPackage = "com.firestone.bean.entity.mysql.primary";
        MybatisSqlSessionFactoryBean factory = new MybatisSqlSessionFactoryBean();
        // 数据源
        factory.setDataSource(dataSource);
        //factory.
        SqlSessionFactory object = factory.getObject();


        return factory.getObject();

    }*/


}
