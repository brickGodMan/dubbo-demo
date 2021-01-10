package com.qiancy.dubbo.demo.account.config;

import com.qiancy.dubbo.demo.account.context.DynamicDataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 功能简述：
 *
 * @author qiancy
 * @create 2021/1/5
 * @since 1.0.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> backupTargetDataSources;

    /**
     * 自定义构造函数
     */
    public DynamicDataSource(DataSource defaultDataSource, Map<Object, Object> targetDataSource){
        backupTargetDataSources = targetDataSource;
        super.setDefaultTargetDataSource(defaultDataSource);
        super.setTargetDataSources(backupTargetDataSources);
        super.afterPropertiesSet();
    }

    /**
     * 添加新数据源
     */
    public void addDataSource(String key, DataSource dataSource){
        this.backupTargetDataSources.put(key,dataSource);
        super.setTargetDataSources(this.backupTargetDataSources);
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }
}
