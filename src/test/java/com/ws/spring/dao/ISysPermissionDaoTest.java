package com.ws.spring.dao;

import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ISysPermissionDaoTest {


    @Autowired
    private ISysPermissionDao iSysPermissionDao;

    @Test
    public void getPermissionById() throws Exception {
        SysPermission sysRole = iSysPermissionDao.getPermissionById(1);
        System.out.println(sysRole.getUrl());
    }

    @Test
    public void getPermissionRoleById() throws Exception {
        List<SysPermission> listSysRole = iSysPermissionDao.getPermissionRoleById(1);
        listSysRole.forEach(l-> System.out.println(l.getUrl()));
    }

    @Test
    public void getPermissionsByRoleId() throws Exception {
        System.out.println(iSysPermissionDao.getPermissionsByRoleId(2));
    }
}