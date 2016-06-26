package edu.whu.irlab.dao;

import edu.whu.irlab.model.User;
import edu.whu.irlab.model.UserRoleKey;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);
}