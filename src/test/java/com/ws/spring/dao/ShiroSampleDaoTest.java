package com.ws.spring.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShiroSampleDaoTest {

    @Autowired
    private ShiroSampleDao shiroSampleDao;

    @Test
    public void getRolesByUserName() throws Exception {
        Set<String> strings =  shiroSampleDao.getRolesByUserName("admin");
        strings.forEach(System.out::println);
    }

    @Test
    public void getPermissionsByRole() throws Exception {
        Set<String> strings =  shiroSampleDao.getPermissionsByRole("admin");
        strings.forEach(System.out::println);
    }

}