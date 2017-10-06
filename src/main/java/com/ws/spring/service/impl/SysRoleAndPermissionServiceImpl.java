package com.ws.spring.service.impl;

import com.ws.spring.dao.ISysPermissionDao;
import com.ws.spring.dao.ISysRoleDao;
import com.ws.spring.dao.IUserInfoDao;
import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import com.ws.spring.service.ISysRoleAndPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysRoleAndPermissionServiceImpl implements ISysRoleAndPermissionService {

    @Autowired
    private ISysRoleDao iSysRoleDao;

    @Autowired
    private ISysPermissionDao iSysPermissionDao;

    @Autowired
    private IUserInfoDao iUserInfoDao;

    @Override
    public List<SysPermission> getPermissionRoleById(Integer id) {
        return iSysPermissionDao.getPermissionRoleById(id);
    }


    @Override
    public SysPermission getPermissionById(Integer id) {
        return iSysPermissionDao.getPermissionById(id);
    }

    @Override
    public SysRole getSysRoleUserById(Integer id) {
        return iSysRoleDao.getSysRoleUserById(id);
    }


    @Cacheable(value = "roleId", key = "#id+'getSysRoleById'")
    @Override
    public SysRole getSysRoleById(Integer id) {
        return iSysRoleDao.getSysRoleById(id);
    }


    @Cacheable(value = "roles",key = "'getRoles'")
    @Override
    public List<SysRole> getAllRoles() {
        return iSysRoleDao.getAllRoles();
    }


    @Cacheable(value = "permissions", key = "'getPermissions'")
    @Override
    public List<SysPermission> getAllPermissions() {
        return iSysPermissionDao.getAllPermissions();
    }


    @Cacheable(value = "userRole", key = "#username+'getUserRoleByUsername'")
    @Override
    public SysRole getUserRoleByUsername(String username) {
        int uid = iUserInfoDao.getIdByUsername(username);
        return iSysRoleDao.getSysRoleByUid(uid);
    }


    @Cacheable(value = "rolePermission", key = "#username+'getRolePermissionByUsername'")
    @Override
    public SysRole getRolePermissionByUsername(String username) {
        int uid = iUserInfoDao.getIdByUsername(username);
        return iSysRoleDao.getRolePermissionByUid(uid);
    }


}
