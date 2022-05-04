package com.zdl.controller;

import com.zdl.service.TestProssService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class TestProssController {
    @Resource
    TestProssService testProssService;
    @GetMapping("/insert")
    @ResponseBody
    public void insertTestData(){
        testProssService.insertTestData();

    }

}
