package com.yhm.microserviceswagger.config.web;

public class WebFluxMvcConfig{}

//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.reactive.config.ResourceHandlerRegistry;
//import org.springframework.web.reactive.config.WebFluxConfigurer;
//import reactor.core.publisher.Mono;
//
////@EnableWebFluxSecurity
////@EnableReactiveMethodSecurity
//public class WebFluxMvcConfig implements WebFluxConfigurer {
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//
//    }
//
//    @Bean
//    public SecurityWebFilterChain SecurityWebFilterChain(ServerHttpSecurity  http) throws Exception {
//        //UsernamePasswordAuthenticationFilter用户名密码校验filter
//
//        http.csrf().disable()
//                .authorizeExchange()
//                // swagger start
//                .pathMatchers("/swagger-ui.html").permitAll()
//                .pathMatchers("/swagger-resources/**").permitAll()
//                .pathMatchers("/images/**").permitAll()
//                .pathMatchers("/webjars/**").permitAll()
//                .pathMatchers("/").permitAll()
//                .pathMatchers("/csrf").permitAll()
//                .pathMatchers("/**/v2/api-docs").permitAll()
//                .pathMatchers("/v2/api-docs").permitAll()
//                .pathMatchers("/configuration/ui").permitAll()
//                .pathMatchers("/configuration/security").permitAll()
//                // swagger end
//                // 所有请求都需要认证
//                .anyExchange().authenticated();
//
//
//
//        return http.build();
//
//    }
//
//
//    /*@Bean
//    public MapReactiveUserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("123").roles("user").build());
//        manager.createUser(User.withDefaultPasswordEncoder().username("user1").password("456").roles("user").build());
//        manager.createUser(User.withDefaultPasswordEncoder().username("user21").password("456").roles("user").build());
//        return manager;
//    }*/
//
//
//}
