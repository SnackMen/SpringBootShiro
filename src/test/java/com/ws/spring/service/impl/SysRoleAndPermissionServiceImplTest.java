package com.ws.spring.service.impl;

import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import com.ws.spring.service.ISysRoleAndPermissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SysRoleAndPermissionServiceImplTest {



    @Autowired
    private ISysRoleAndPermissionService sysRoleAndPermissionService;


    @Test
    public void getSysRoleById() throws Exception {
        SysRole sysRole = sysRoleAndPermissionService.getSysRoleById(2);
        System.out.println(sysRole);
    }

    @Test
    public void getAllRoles() throws Exception {
        List<SysRole> list = sysRoleAndPermissionService.getAllRoles();
        System.out.println(list);
    }

    @Test
    public void getAllPermissions() throws Exception {
        List<SysPermission> sysPermissionList = sysRoleAndPermissionService.getAllPermissions();
        System.out.println(sysPermissionList);
    }


    @Test
    public void getPermissionById() throws Exception {
        SysPermission permission = sysRoleAndPermissionService.getPermissionById(3);
        System.out.println(permission);
    }

    @Test
    public void getUserRoleByUsername() throws Exception {
        SysRole sysRole = sysRoleAndPermissionService.getRolePermissionByUsername("test");
        System.out.println(sysRole);
    }

    @Test
    public void getRolePermissionByUsername() throws Exception {
        SysRole sysRole = sysRoleAndPermissionService.getRolePermissionByUsername("test");
        System.out.println(sysRole);
    }
}