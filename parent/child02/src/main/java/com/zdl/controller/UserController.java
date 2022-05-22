package com.zdl.controller;

import com.zdl.service.serviceimpl.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    UserServiceImpl userService;

    @GetMapping("/getUser")
    public String getUser(){
        return userService.getUser();
    }
}
