package edu.whu.irlab.service.impl;

import edu.whu.irlab.dao.RolePermissionMapper;
import edu.whu.irlab.model.RolePermissionKey;
import edu.whu.irlab.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Roger on 2016/5/24.
 */
@Service("RolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Override
    public int deleteByPrimaryKey(RolePermissionKey key) {
        return rolePermissionMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(RolePermissionKey record) {
        return rolePermissionMapper.insert(record);
    }

    @Override
    public int insertSelective(RolePermissionKey record) {
        return rolePermissionMapper.insertSelective(record);
    }
}
