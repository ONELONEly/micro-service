package com.yhm.microservicegateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/asdasd")
    public String ttt(){
        return "asd";
    }
}
