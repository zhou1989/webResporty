package com.zdl;


import com.zdl.datasource.Ds1Config;
import com.zdl.datasource.Ds2Config;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * springboot入口类,此类需要在所有用到的package上层
 * exclude = {DataSourceAutoConfiguration.class}
 * 禁用springboot默认加载的application.properties单数据源配置
 */
@EnableAutoConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class}, scanBasePackages = {"com.zdl.service.*", "com.zdl.controller", "com.zdl.mapper.*"})
@MapperScan(basePackages = {"com.zdl.mapper.*"})
@Import({Ds1Config.class, Ds2Config.class}) // 注册动态多数据源
public class ApplicationMain {
    public static void main(String[] args) {

        SpringApplication.run(ApplicationMain.class, args);
    }

}
