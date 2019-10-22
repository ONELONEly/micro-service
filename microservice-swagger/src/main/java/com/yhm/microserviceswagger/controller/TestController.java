package com.yhm.microserviceswagger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/aa")
    public String ttt(){
        return "aa";
    }
}
