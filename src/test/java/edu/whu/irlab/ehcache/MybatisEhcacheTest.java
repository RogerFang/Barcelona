package edu.whu.irlab.ehcache;

import edu.whu.irlab.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Roger on 2016/6/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class MybatisEhcacheTest {

    @Autowired
    private UserService userService;

    /**
     * 从两次数据库操作中可以看出时间差距很大, 缓存的作用还是很明显
     */
    @Test
    public void testEhcache(){
        Long begin = System.nanoTime();
        userService.selectAll();
        System.out.println("1:"+(System.nanoTime()-begin));

        begin = System.nanoTime();
        userService.selectAll();
        System.out.println("2:"+(System.nanoTime() - begin));
    }
}
