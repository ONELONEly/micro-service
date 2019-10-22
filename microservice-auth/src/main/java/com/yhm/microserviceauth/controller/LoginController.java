package com.yhm.microserviceauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController  {

    @RequestMapping("/login")
    public String login(){
        return "/login";
}
    @RequestMapping(method = RequestMethod.DELETE, value = "/test")
    public String test(){
        System.out.println("asd");
       return "/login123";
    }
}
