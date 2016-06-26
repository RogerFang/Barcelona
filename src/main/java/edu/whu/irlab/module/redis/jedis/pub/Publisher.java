package edu.whu.irlab.module.redis.jedis.pub;

import redis.clients.jedis.Jedis;

/**
 * 实现pub/sub发布订阅模式
 * 消息发布
 *
 * Created by Roger on 2016/6/14.
 */
public class Publisher {

    public void publish(final Jedis redisClient){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("发布: log");

                redisClient.publish("log.debug", "log is debug.");
                redisClient.publish("log.info", "log is info.");
                redisClient.publish("log.error", "log is error.");
            }
        }).start();
    }
}
