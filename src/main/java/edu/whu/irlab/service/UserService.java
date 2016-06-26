package edu.whu.irlab.service;

import edu.whu.irlab.model.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Roger on 2016/5/24.
 */
public interface UserService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(User record);

    public int insertSelective(User record);

    public User selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(User record);

    public int updateByPrimaryKey(User record);

    public User selectByUsername(String username);

    public User selectWithRolesByUsername(String username);

    public Set<String> selectRolesByUsername(String username);

    public List<User> selectAll();

    public int register(User user);
}
