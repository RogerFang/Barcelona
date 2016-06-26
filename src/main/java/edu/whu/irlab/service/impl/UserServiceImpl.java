package edu.whu.irlab.service.impl;

import edu.whu.irlab.dao.UserMapper;
import edu.whu.irlab.model.User;
import edu.whu.irlab.service.UserService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * Created by Roger on 2016/5/24.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    @Override
    public User selectByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public User selectWithRolesByUsername(String username) {
        return userMapper.selectWithRolesByUsername(username);
    }

    @Override
    public Set<String> selectRolesByUsername(String username) {
        return userMapper.selectRolesByUsername(username);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int register(User user) {
        entryptPassword(user);
        return insertSelective(user);
    }

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private void entryptPassword(User user){
        String salt = randomNumberGenerator.nextBytes().toHex();
        String hashPassword = new Md5Hash(user.getPassword(), salt).toString();
        user.setPassword(hashPassword);
        user.setLocked(false);
        user.setSalt(salt);
    }
}
