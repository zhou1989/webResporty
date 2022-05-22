package com.zdl.controller;

import com.zdl.service.serviceimpl.CityServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CityController {
    @Resource
    CityServiceImpl cityService;

    @GetMapping("/getCity")
    public String getCity(){
        return cityService.getCity();
    }
}
