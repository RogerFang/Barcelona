package edu.whu.irlab.module.redis.springdataredis.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by Roger on 2016/6/14.
 */
@Service
public class PublisheService {

    @Autowired
    private RedisTemplate redisTemplate;


    // 发布消息到channel
    public void publish(String channel, String message){
        redisTemplate.convertAndSend(channel, message);
    }
}
