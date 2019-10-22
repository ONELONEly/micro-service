package com.yhm.microserviceauth.config.mybatisPlus;

import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.yhm.microserviceauth.config.mybatisPlus.intercetor.CommonLogicSqlInjector;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author miemie
 * @since 2018-08-12
 */
@Configuration
public class CommonMybatisPlusConfig {

    /**
     * 1.分页插件
     * 2.多租户
     */
    @Bean
    @ConditionalOnMissingBean(PaginationInterceptor.class)
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(OptimisticLockerInterceptor.class)
    public OptimisticLockerInterceptor optimisticLockerInterceptor(){
        return new OptimisticLockerInterceptor();
    }

    /**
     * 自定义 SqlInjector
     * 里面包含自定义的全局方法
     */
    @Bean
    @ConditionalOnMissingBean(CommonLogicSqlInjector.class)
    public CommonLogicSqlInjector myLogicSqlInjector() {
        return new CommonLogicSqlInjector();
    }
}
