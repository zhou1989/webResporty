package com.zdl;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.core.env.Environment;

/**
 * springboot入口类,此类需要在所有用到的package上层
 * exclude = {DataSourceAutoConfiguration.class}
 * 禁用springboot默认加载的application.properties单数据源配置
 */
@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class},scanBasePackages ={"com.zdl.service.*","com.zdl.controller","com.zdl.mapper.*"})
@MapperScan(basePackages ={"com.zdl.mapper.*"})
//@Import({DynamicDataSourceConfig.class}) // 注册动态多数据源
public class ApplicationMain {

    @Autowired
    static Environment env;

    public static void main(String[] args) {


            SpringApplication.run(ApplicationMain.class, args);
    }

}
