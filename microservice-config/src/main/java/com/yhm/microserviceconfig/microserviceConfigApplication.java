package com.yhm.microserviceconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class microserviceConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(microserviceConfigApplication.class, args);
    }
}
