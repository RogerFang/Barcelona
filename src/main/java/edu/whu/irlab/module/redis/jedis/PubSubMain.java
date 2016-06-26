package edu.whu.irlab.module.redis.jedis;

import edu.whu.irlab.module.redis.jedis.listener.RedisPubSubListener;
import edu.whu.irlab.module.redis.jedis.pub.Publisher;
import edu.whu.irlab.module.redis.jedis.sub.Subscriber;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 实现pub/sub发布订阅模式
 *
 * Created by Roger on 2016/6/14.
 */
public class PubSubMain {

    public static void main(String[] args) {

        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(0);
        config.setMaxTotal(20);
        config.setMaxWaitMillis(1000);
        config.setTestOnBorrow(true);

        // 依赖jar包 commons-pool2.jar
        // 创建连接池
        JedisPool pool = new JedisPool(config, "127.0.0.1", 6379);

        // 获取客户端
        Jedis redisClient1 = pool.getResource();
        Jedis redisClient2 = pool.getResource();
        RedisPubSubListener listener = new RedisPubSubListener();

        // 发布一个频道
        Publisher pub = new Publisher();
        pub.publish(redisClient1);
        // 或者在redis客户端使用redis-cli 输入：publish log.warn "log is warn" 观察接收消息

        // 订阅一个频道
        Subscriber sub = new Subscriber();
        sub.sub(redisClient2, listener);
    }
}
