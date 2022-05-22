package com.zdl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private Environment env;

    @GetMapping("/firstPage")
    public String firstPage(){
        System.out.print(env.getProperty("spring.datasource.ds1.url"));
        return "欢迎来到web学习测试平台";
    }

}
