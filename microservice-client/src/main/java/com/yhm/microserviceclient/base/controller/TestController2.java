package com.yhm.microserviceclient.base.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yhm.microservicecommon.constant.AuthConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/t2")
public class TestController2 {
    @Autowired
    private Environment env;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/test")
    public String test(HttpServletRequest request) {
        System.out.println(request.getHeader(AuthConstants.AUTH_HEADER));
        System.out.println(request.getHeader("x-forwarded-for"));
        return env.getProperty("server.port");
    }

    //负载均衡测试
    @RequestMapping("/getPort")
    public String aaa() {
        String forObject = "";
        //同步
        forObject = restTemplate.getForObject("http://microServiceClient/t2/test", String.class);
        //int i = 1/0;
        return forObject;
    }



    //熔断器测试
    @HystrixCommand(fallbackMethod = "testFallback"
            , commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    @RequestMapping("/testHystrix")
    public String testHystrix() {
        String forObject = "";
        //超时服务调用
        //forObject = restTemplate.getForObject("http://microServiceClient/t2/timeOutService", String.class);

        //异常服务调用
        forObject = restTemplate.getForObject("http://microServiceClient/t2/errorService", String.class);

        System.out.println("测试任务");
        //int i = 1/0;
        return forObject;
    }

    //超时测试
    @RequestMapping("/timeOutService")
    public String timeOutService() throws InterruptedException {

        Thread.sleep(2000);
        System.out.println("任务超时");

        return "error";

    }
    //抛出异常测试
    @RequestMapping("/errorService")
    public String errorService() throws InterruptedException {

        int i = 1/0;

        return "error";

    }
    public String testFallback() {
        System.out.println("任务异常");
        return "error";

    }

    @RequestMapping("/tt")
    @ResponseBody
    public String tt(String token){
        //System.out.println(restTemplate.getForObject("http://microServiceAuth/oauth/check_token?token="+token,Object.class));
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://MICROSERVICEAUTH/oauth/check_token?token={1}", String.class, "123");
        String s =  forEntity.getBody();
        System.out.println(s);
        return "";
    }

}
