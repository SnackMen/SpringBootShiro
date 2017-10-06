package com.ws.spring.dao;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserInfoDaoTest {


    @Autowired
    private IUserInfoDao iUserInfoDao;

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getPasswordByUserName() throws Exception {
        System.out.println(iUserInfoDao.getPasswordByUserName("admin"));
    }

    @Test
    public void getAll() throws Exception {
    }

    @Test
    public void getUserById() throws Exception {
    }

    @Test
    public void getIdByUsername() throws Exception {
        System.out.println(iUserInfoDao.getIdByUsername("test"));
    }

}