package com.zdl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages ={"com.zdl.service.serviceimpl","com.zdl.controller","com.zdl.mapper"})
@MapperScan(basePackages ={"com.zdl.mapper"})
public class ApplicationMain {

    public static void main(String[] args) {
        try{
            SpringApplication.run(ApplicationMain.class, args);
        }catch (Exception e){
            System.out.print("*************"+e.getMessage()+"********************");
        }


    }

}
