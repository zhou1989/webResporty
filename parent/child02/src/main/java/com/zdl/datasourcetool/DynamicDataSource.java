package com.zdl.datasourcetool;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * 获取当前数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDB();
    }
}
