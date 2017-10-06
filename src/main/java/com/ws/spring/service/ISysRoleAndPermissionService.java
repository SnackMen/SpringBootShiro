package com.ws.spring.service;

import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISysRoleAndPermissionService {

    List<SysPermission> getPermissionRoleById(Integer id);

    SysPermission getPermissionById(Integer id);

    SysRole getSysRoleUserById(Integer id);

    SysRole getSysRoleById(Integer id);

    List<SysRole> getAllRoles();

    List<SysPermission> getAllPermissions();

    /**
     * 通过用户名查询用户和角色之间关系
     * @param username
     * @return
     */
    SysRole getUserRoleByUsername(String username);

    /**
     * 通过用户名查询角色和权限之间关系
     * @param username
     * @return
     */
    SysRole getRolePermissionByUsername(String username);

}
