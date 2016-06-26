package edu.whu.irlab.module.schedule;

/**
 * 在使用shiro时，如果Quartz 为Quartz 2的版本，
 * 则抛出异常Java.lang.InstantiationError: org.quartz.SimpleTrigger。
 * 原因是默认的shiro-quartz1.2.3中的实现是针对quartz1.6版本的实现
 *
 * Created by Roger on 2016/5/26.
 */
public class QuartzJob {

    /**
     * 具体任务
     */
    public void doJob(){
        System.out.println("This is a Scheduled Job!");
    }
}
