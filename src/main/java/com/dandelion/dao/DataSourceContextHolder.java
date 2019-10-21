package com.dandelion.dao;

/**
 * className DataSourceContextHolder
 * description 标识存放ThreadLocal的实现
 * @author puyiliang
 * @date 2019/10/21 16:06
 */
public class DataSourceContextHolder {

    /**
     * 主从枚举
     * MASTER 主
     * SLAVE 从
     */
    public enum DataSourceType{
        MASTER,SLAVE
    }

    private static final ThreadLocal<DataSourceType> CONTEXT_HOLDER = new ThreadLocal<>();

    public static void setDataSourceType(DataSourceType dbType){
        if(dbType==null){
            throw new NullPointerException();
        }
        CONTEXT_HOLDER.set(dbType);
    }

    public static DataSourceType getDataSourceType(){
        return CONTEXT_HOLDER.get()==null?DataSourceType.MASTER:CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceType(){
        CONTEXT_HOLDER.remove();
    }
}
