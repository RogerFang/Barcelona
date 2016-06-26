package edu.whu.irlab.module.redis.springdataredis.pub;

import edu.whu.irlab.module.redis.jedis.pub.Publisher;
import edu.whu.irlab.module.redis.springdataredis.sub.SubscribeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2016/6/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class PublisheServiceTest {
    @Autowired
    private PublisheService publisheService;

    @Test
    public void publish(){
        publisheService.publish("user:topic", "Hello this is a publish message!");
    }
}