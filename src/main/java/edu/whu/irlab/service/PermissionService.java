package edu.whu.irlab.service;

import edu.whu.irlab.model.Permission;

/**
 * Created by Roger on 2016/5/24.
 */
public interface PermissionService {
    public int deleteByPrimaryKey(Integer id);

    public int insert(Permission record);

    public int insertSelective(Permission record);

    public Permission selectByPrimaryKey(Integer id);

    public int updateByPrimaryKeySelective(Permission record);

    public int updateByPrimaryKey(Permission record);
}
