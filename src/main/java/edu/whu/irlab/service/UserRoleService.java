package edu.whu.irlab.service;

import edu.whu.irlab.model.UserRoleKey;

/**
 * Created by Roger on 2016/5/24.
 */
public interface UserRoleService {
    public int deleteByPrimaryKey(UserRoleKey key);

    public int insert(UserRoleKey record);

    public int insertSelective(UserRoleKey record);
}
