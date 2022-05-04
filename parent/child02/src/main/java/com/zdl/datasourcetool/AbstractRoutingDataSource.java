package com.zdl.datasourcetool;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.Map;

public abstract class AbstractRoutingDataSource extends AbstractDataSource implements InitializingBean {
    //多数据源map集合
    private Map<Object, Object> targetDataSources;
    //默认数据源
    private Object defaultTargetDataSource;
    //其实就是targetDataSources，后面的afterPropertiesSet（）方法会将targetDataSources赋值给resolvedDataSources
    private Map<Object, DataSource> resolvedDataSources;

    private DataSource resolvedDefaultDataSource;
    //设置目标数据源
    public void setTargetDataSources(Map<Object, Object> targetDataSources) {
        this.targetDataSources = targetDataSources;
    }
    //解析当前数据源
    protected DataSource determineTargetDataSource() {
        Assert.notNull(this.resolvedDataSources, "DataSource router not initialized");
        Object lookupKey = this.determineCurrentLookupKey();
        //获取数据源
        DataSource dataSource = (DataSource)this.resolvedDataSources.get(lookupKey);
//        if (dataSource == null && (this.lenientFallback || lookupKey == null)) {
//            dataSource = this.resolvedDefaultDataSource;
//        }
        if (dataSource == null) {
            throw new IllegalStateException("Cannot determine target DataSource for lookup key [" + lookupKey + "]");
        } else {
            return dataSource;
        }
    }


    protected abstract Object determineCurrentLookupKey();
}
