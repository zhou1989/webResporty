package com.zdl.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Ds1Config.PACKAGE, sqlSessionFactoryRef = "ds1SqlSessionFactory")
public class Ds1Config {
    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.zdl.mapper.ds1";
    static final String MAPPER_LOCATION = "classpath:mapper/ds1/*Mapper.xml";

    @Value("${spring.datasource.ds1.url}")
    private String url;

    @Value("${spring.datasource.ds1.username}")
    private String user;

    @Value("${spring.datasource.ds1.password}")
    private String password;

    @Value("${spring.datasource.ds1.driver-class-name}")
    private String driverClass;

    @Value("${spring.datasource.ds1.type}")
    private String type;


    @Bean(name = "ds1DataSource")
    @Primary
    public DataSource ds1DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setDbType(type);
        return dataSource;
    }

    @Bean(name = "ds1TransactionManager")
    @Primary
    public DataSourceTransactionManager ds1TransactionManager() {
        return new DataSourceTransactionManager(ds1DataSource());
    }


    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("ds1DataSource") DataSource ds1DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds1DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Ds1Config.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

}
