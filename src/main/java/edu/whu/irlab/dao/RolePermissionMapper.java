package edu.whu.irlab.dao;

import edu.whu.irlab.model.RolePermissionKey;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePermissionMapper {
    int deleteByPrimaryKey(RolePermissionKey key);

    int insert(RolePermissionKey record);

    int insertSelective(RolePermissionKey record);
}