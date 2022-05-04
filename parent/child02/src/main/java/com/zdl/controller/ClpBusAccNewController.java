package com.zdl.controller;

import com.zdl.service.ClpBusAccNewService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ClpBusAccNewController {

    @Resource
    ClpBusAccNewService clpBusAccNewService;

    @ResponseBody
    @GetMapping("inserts")
    public int insertData(){
        int i =clpBusAccNewService.insertData();
        return i;
    }

}
