package com.dandelion.dao;

/**
 * className DataSourceContextHolder
 * description 标识存放ThreadLocal的实现
 * @author puyiliang
 * @date 2019/10/21 16:06
 */
public class DataSourceContextHolder {

    public enum DataSourceType{
        MASTER,SLAVE
    }

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType dbType){
        if(dbType==null)throw new NullPointerException();
        contextHolder.set(dbType);
    }

    public static DataSourceType getDataSourceType(){
        return contextHolder.get()==null?DataSourceType.MASTER:contextHolder.get();
    }

    public static void clearDataSourceType(){
        contextHolder.remove();
    }
}
