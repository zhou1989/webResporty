package com.zdl.controller;

import com.zdl.service.serviceimpl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CityController {

    @Autowired
    Environment environment;
    @Resource
    CityServiceImpl cityService;

    @GetMapping("/getCity")
    public String getCity(){
        return cityService.getCity();
//        String url = environment.getProperty("spring.datasource.druid.ds3.url");
//       return url;
    }

}
