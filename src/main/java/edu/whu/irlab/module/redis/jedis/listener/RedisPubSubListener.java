package edu.whu.irlab.module.redis.jedis.listener;

import redis.clients.jedis.JedisPubSub;

/**
 * 实现发布订阅(pub/sub)模式
 * 消息监听器
 *
 * Created by Roger on 2016/6/14.
 */
public class RedisPubSubListener extends JedisPubSub {

    // 取得订阅的消息后的处理
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage: channel[" + channel + "], message[" + message + "]");
    }

    // 取得按表达式的方式订阅的消息后的处理
    @Override
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println("onPMessage: pattern[" + pattern + "],channel[" + channel + "], message[" + message + "]");
    }

    // 初始化订阅时候的处理
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe: channel[" + channel + "]," + "subscribedChannels[" + subscribedChannels + "]");
    }

    // 取消订阅时候的处理
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {
        System.out.println("onUnsubscribe: channel[" + channel + "], " + "subscribedChannels[" + subscribedChannels + "]");
    }

    // 取消按表达式的方式订阅时候的处理
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPUnsubscribe: pattern[" + pattern + "]," +
                "subscribedChannels[" + subscribedChannels + "]");
    }

    // 初始化按表达式的方式订阅时候的处理
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {
        System.out.println("onPSubscribe: pattern[" + pattern + "], " +
                "subscribedChannels[" + subscribedChannels + "]");
    }
}
