package com.dandelion.config;

import com.dandelion.dao.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * className ReadWriteSplitRoutingDataSource
 * description 根据标识获取不同数据源（读写分离配置）
 *
 * @author puyiliang
 * @date 2019/10/21 16:40
 */
public class ReadWriteSplitRoutingDataSource extends AbstractRoutingDataSource{
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSourceType();
    }
}
