package com.yhm.microserviceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class microserviceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(microserviceServerApplication.class, args);
    }
}
