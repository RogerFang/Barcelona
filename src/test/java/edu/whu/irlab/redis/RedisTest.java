package edu.whu.irlab.redis;

import edu.whu.irlab.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Roger on 2016/6/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;
    
    @Test
    public void add(){
        // ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        // valueOperations.set("10", "Roger");
        // System.out.println(valueOperations.get("10"));

        User user = new User();
        user.setId(10);
        user.setUsername("Roger");

        // POJO必须实现Serializable接口

        //ValueOperations => 简单K-V操作
        ValueOperations<String, User> vo = redisTemplate.opsForValue();
        vo.set("user:"+user.getUsername(), user);
        User userVo = vo.get("user:Roger");
        System.out.println("VO user: id="+userVo.getId()+" name="+userVo.getUsername());

        //ListOperations => List, 针对list类型的数据操作
        ListOperations<String, User> lo = redisTemplate.opsForList();
        lo.rightPush("users_list", user);
        List<User> users = lo.range("users_list", 0, -1);
        System.out.println("LO users_list: size=" + users.size());

        //HashOperations => Map, 针对map类型的数据操作
        HashOperations<String, Integer, User> ho = redisTemplate.opsForHash();
        //存放多个user
        ho.put("users_hash", user.getId(), user);
        //获取所有user
        Map<Integer, User> userMap = ho.entries("users_hash");
        //获取单个user
        User userhash = ho.get("users_hash", user.getId());
        System.out.println("HO users_hash: size="+userMap.size());
        System.out.println("HO users_hash: user:"+userhash.getId()+" name:"+userhash.getUsername());

        //SetOperations => Set, set类型数据操作
        SetOperations<String, User> so = redisTemplate.opsForSet();
        so.add("users_set", user);
        Set<User> userSet = so.members("users_set");
        System.out.println("SO users_set: size="+userSet.size());

        //ZSetOperations => ZSet, zset类型数据操作
        ZSetOperations<String, User> zso = redisTemplate.opsForZSet();
        zso.add("users_zset", user, 1.5);
        //根据score排序, 取出min~max之间的
        Set<User> userZSet = zso.rangeByScore("users_zset", 1.5, 1.6);
        System.out.println("ZSO users_zset: size="+userZSet.size());
    }
}
