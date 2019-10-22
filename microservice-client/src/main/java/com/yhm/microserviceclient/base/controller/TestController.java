package com.yhm.microserviceclient.base.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.yhm.microserviceclient.base.controller.command.UserObservableCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TestController {

    //动态配置不要以此方式获取，注入后属性值不会更改
    @Value("${test}")
    private String test;

    @Autowired
    private Environment env;

    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "testFallback"
            , commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "4000")
    })
    @GetMapping("/aaa")
    public String aaa() {
        String forObject = "aas";
        //同步
        forObject = restTemplate.getForObject("http://microServiceClient/test", String.class);
        System.out.println("2222");
        //int i = 1/0;
        return forObject;
    }

    /* @HystrixCommand(fallbackMethod   = "testFallback"
             ,commandProperties = {
             @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "4000")
     })*/
    @GetMapping("/bbb")
    public Future<String> bbb() throws ExecutionException, InterruptedException {
        String forObject = "aas";

        AsyncResult<String> result = new AsyncResult<String>() {

            @Override
            public String invoke() {
                return restTemplate.getForObject("http://microServiceClient/test", String.class);
            }
        };
        //异步
        //int i = 1/0;
        System.out.println("2222");
        System.out.println(result.get());
        //forObject = asyncResult.get();
        return result;
    }


    public String testFallback() {
        return "error";

    }

    @GetMapping("/ccc")
    public String test() {


        return "";
    }


    @GetMapping("/test/{id}")
    public String get(@PathVariable("id") Integer id) throws InterruptedException {

        return "你输得的id是" + id;
    }


    @GetMapping("/test")
    public String test3() throws InterruptedException {
        Thread.sleep(200);
        System.out.println("1111");
        return test;
    }

    @GetMapping("/test2")
    public String test2() {

        return env.getProperty("test");
    }
}


