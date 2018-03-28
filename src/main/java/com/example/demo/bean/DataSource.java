package com.example.demo.bean;

import com.example.demo.datasource.DynamicDataSource;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源: 通过AOP在不同数据源之间动态切换
 *
 * @return
 */
@Bean(name = "dynamicDS1")
public class DataSource {

    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    // 默认数据源
        dynamicDataSource.setDefaultTargetDataSource(dataSource1());

    // 配置多数据源
    Map<Object, Object> dsMap = new HashMap(5);
        dsMap.put("titan-master", dataSource1());
        dsMap.put("ds2", dataSource2());

        dynamicDataSource.setTargetDataSources(dsMap);

        return dynamicDataSource;
}
