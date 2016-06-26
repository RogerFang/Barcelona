package edu.whu.irlab.module.redis.jedis.sub;

import edu.whu.irlab.module.redis.jedis.listener.RedisPubSubListener;
import redis.clients.jedis.Jedis;

/**
 * 实现pub/sub发布订阅模式
 * 消息订阅
 *
 * Created by Roger on 2016/6/14.
 */
public class Subscriber {

    public void sub(final Jedis redisClient, final RedisPubSubListener listener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("订阅: log");
                // 订阅得到的信息在listener中的onMessage()方法中进行处理

                // 订阅多个频道
                // redisClient.subscribe(listener, "log,debug", "log.info");
                // redisClient.subscribe(listener, new String[]{"log.debug", "log.info"});

                // 使用模式匹配的方式设置频道
                redisClient.psubscribe(listener, new String[]{"log.*"});
            }
        }).start();
    }
}
