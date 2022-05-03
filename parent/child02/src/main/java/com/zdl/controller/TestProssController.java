package com.zdl.controller;

import com.zdl.service.TestProssService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class TestProssController {
    @Resource
    TestProssService testProssService;

    public int insertTestData(){
        int i =testProssService.insertTestData();
        return i;
    }

}
