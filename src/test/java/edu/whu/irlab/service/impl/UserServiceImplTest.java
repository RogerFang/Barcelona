package edu.whu.irlab.service.impl;

import edu.whu.irlab.model.User;
import edu.whu.irlab.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by Roger on 2016/5/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext*.xml"})
public class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSelectByUsername(){
        User user = userService.selectByUsername("roger");
        user.getUsername();
    }

    /**
     * 当user_role不存在记录而user存在记录时,会造成select为空
     */
    @Test
    public void testSelectWithRolesByUsername(){
        User user = userService.selectWithRolesByUsername("roger");
        user.getRolesStr();
    }
    @Test
    public void testSelectByPrimaryKey(){
        User user = userService.selectByPrimaryKey(1);
        System.out.println(user.getUsername());
    }

}