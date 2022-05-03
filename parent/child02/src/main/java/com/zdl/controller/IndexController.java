package com.zdl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @ResponseBody
    @GetMapping("/firstPage")
    public String firstPage(){
        return "欢迎来到web学习测试平台";
    }

}
