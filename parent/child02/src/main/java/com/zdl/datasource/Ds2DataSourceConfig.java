package com.zdl.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
// 扫描 Mapper 接口并容器管理
@MapperScan(basePackages = Ds2DataSourceConfig.PACKAGE, sqlSessionFactoryRef = "ds2SqlSessionFactory")
public class Ds2DataSourceConfig {
    // 精确到 cluster 目录，以便跟其他数据源隔离
    static final String PACKAGE = "com.zdl.mapper.ds2";
    static final String MAPPER_LOCATION = "classpath:mapper/ds2/*Mapper.xml";

    @Value("${spring.datasource.ds2.url}")
    private String url;

    @Value("${spring.datasource.ds2.username}")
    private String user;

    @Value("${spring.datasource.ds2.password}")
    private String password;

    @Value("${spring.datasource.ds2.driver-class-name}")
    private String driverClass;

    @Value("${spring.datasource.ds2.type}")
    private String type;

    @Bean(name = "ds2DataSource")
    public DataSource ds2DataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean(name = "ds2TransactionManager")
    public DataSourceTransactionManager clusterTransactionManager() {
        return new DataSourceTransactionManager(ds2DataSource());
    }

    @Bean(name = "ds2SqlSessionFactory")
    public SqlSessionFactory clusterSqlSessionFactory(@Qualifier("ds2DataSource") DataSource ds2DataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(ds2DataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(Ds2DataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
