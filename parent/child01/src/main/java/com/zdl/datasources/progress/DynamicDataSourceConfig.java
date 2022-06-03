package com.zdl.datasources.progress;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Configuration
@MapperScan(basePackages = "com.zdl.mapper")
public class DynamicDataSourceConfig {
    @Autowired
    private BeanFactory beanFactory;
    @Autowired
    private DynamicDataSourceProperty dynamicDataSourceProperty;
    /**
     * 功能描述: <br>
     * 〈动态数据源bean 自动配置注册所有数据源〉
     *
     * @param
     * @return javax.sql.DataSource
     * @Author li.he
     * @Date 2020/6/4 16:47
     * @Modifier
     */
    @Bean
    @Primary
    public DataSource dynamicDataSource() {
        DefaultListableBeanFactory listableBeanFactory = (DefaultListableBeanFactory) beanFactory;
        /*获取yml所有数据源配置*/
        Map<String, Object> datasource = dynamicDataSourceProperty.getDatasource();
        Map<Object, Object> dataSourceMap = new HashMap<>(5);
        Optional.ofNullable(datasource).ifPresent(map -> {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                //创建数据源对象
                DruidDataSource dataSource = (DruidDataSource) DataSourceBuilder.create().build();
                String dataSourceId = entry.getKey();
                configeDataSource(entry, dataSource);
                /*bean工厂注册每个数据源bean*/
                listableBeanFactory.registerSingleton(dataSourceId, dataSource);
                dataSourceMap.put(dataSourceId, dataSource);
            }
        });

        //AbstractRoutingDataSource设置主从数据源
        return new DynamicDataSource(beanFactory.getBean("ds1", DataSource.class), dataSourceMap);
    }

    private void configeDataSource(Map.Entry<String, Object> entry, DruidDataSource dataSource) {
        Map<String, Object> dataSourceConfig = (Map<String, Object>) entry.getValue();
        dataSource.setJdbcUrl(MapUtils.getString(dataSourceConfig, "jdbcUrl"));
        dataSource.setDriverClassName(MapUtils.getString(dataSourceConfig, "driverClassName"));
        dataSource.setUsername(MapUtils.getString(dataSourceConfig, "username"));
        dataSource.setPassword(MapUtils.getString(dataSourceConfig, "password"));
    }

}
