package com.zdl.datasource;


import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;


@Configuration
@MapperScan("")
public class DynamicProxyDataSourceConfig {

    @Autowired
    Environment env;

    public DataSource newDataSourceInstance(){
        DruidDataSource dataSource = new DruidDataSource();

        return dataSource;
    }


}
