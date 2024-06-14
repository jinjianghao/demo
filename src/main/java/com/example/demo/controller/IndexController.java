package com.example.demo.controller;


import com.example.demo.annotation.LoginRequired;
import com.example.demo.annotation.MyLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping("/sourceA")
    public String sourceA(){
        return "你正在访问sourceA资源";
    }

    //注解+拦截器
    @GetMapping("/sourceB")
    @LoginRequired
    public String sourceB(){
        return "你正在访问sourceB资源";
    }

    //注解+AOP
    @MyLog
    @GetMapping("/sourceC/{source_name}")
    public String sourceC(@PathVariable("source_name") String sourceName){
        return "你正在访问sourceC资源";
    }

}
