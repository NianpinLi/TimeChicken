package com.dandelion.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * className CommonScheduled
 * description 定时任务管理类（所有定时任务在这管理）
 * @author puyiliang
 * @date 2019/10/21 17:54
 */
@Component
@Slf4j
public class BaseScheduled {

    /**
     * 定时任务1
     */
    @Scheduled(fixedDelay = 1000)
    public void printOne(){
        try{
            //睡眠半小时
            Thread.sleep(60000 * 30);
            //打印当前线程名字
            log.info("定时任务1"+Thread.currentThread().getName());

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

    /**
     * 定时任务2
     */
    @Scheduled(fixedDelay = 1000)
    public void printTwo(){
        try{
            //睡眠半小时
            Thread.sleep(60000 * 30);
            //打印当前线程名字
            log.info("定时任务2"+Thread.currentThread().getName());

        }catch (Exception e){
            log.error(e.getMessage());
        }
    }

}
