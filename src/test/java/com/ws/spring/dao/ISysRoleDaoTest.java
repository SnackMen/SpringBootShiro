package com.ws.spring.dao;

import com.ws.spring.entity.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.management.relation.RoleInfo;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ISysRoleDaoTest {

    @Test
    public void getSysRoleUserById() throws Exception {
    }

    @Test
    public void getSysRoleById1() throws Exception {
    }

    @Autowired
    private ISysRoleDao iSysRoleDao;

    @Test
    public void getSysRoleById() throws Exception {
        SysRole roleInfo = iSysRoleDao.getSysRoleById(1);
        System.out.println(roleInfo.getRole());
    }

    @Test
    public void getSysRoleByUid() throws Exception {
        System.out.println(iSysRoleDao.getSysRoleByUid(2));
    }

    @Test
    public void getRolePermissionByUid() throws Exception {
        SysRole sysRole = iSysRoleDao.getRolePermissionByUid(2);
        System.out.println(sysRole.toString());
    }
}