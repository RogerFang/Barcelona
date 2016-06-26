package edu.whu.irlab.service;

import edu.whu.irlab.model.RolePermissionKey;

/**
 * Created by Roger on 2016/5/24.
 */
public interface RolePermissionService {
    public int deleteByPrimaryKey(RolePermissionKey key);

    public int insert(RolePermissionKey record);

    public int insertSelective(RolePermissionKey record);
}
