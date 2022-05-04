package com.zdl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages ={"com.zdl.service.*","com.zdl.controller","com.zdl.mapper.ds1"})
@MapperScan(basePackages ={"com.zdl.mapper.ds1","com.zdl.mapper.ds2"})
public class ApplicationMain {

    public static void main(String[] args) {

            SpringApplication.run(ApplicationMain.class, args);
    }

}
