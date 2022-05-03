package com.zdl.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public interface FirstIndexApi {
    @ResponseBody
    @GetMapping("/firstPage")
    public String firstPage();
}
