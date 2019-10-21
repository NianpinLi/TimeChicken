package com.dandelion.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * className ReadOnlyConnection
 * description 自定义从库注解， 添加此注解走从库查询 注解添加在Service方法上 （读写分离配置）
 * @author puyiliang
 * @date 2019/10/21 16:27
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ReadOnlyConnection {
}
