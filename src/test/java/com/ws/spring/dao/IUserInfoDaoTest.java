package com.ws.spring.dao;

import com.ws.spring.entity.UserInfo;
import com.ws.spring.util.MD5Password;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IUserInfoDaoTest {
    @Test
    public void activateAccount() throws Exception {
        System.out.println(iUserInfoDao.activateAccount("wangshu"));
    }

    @Test
    public void registerMessage() throws Exception {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("wangshu");
        userInfo.setPassword(MD5Password.md5Entry("123456"));
        userInfo.setSalt(MD5Password.md5Entry("123456"));
        userInfo.setName("winson");
        userInfo.setEmail("vipkia@sina.cn");
        userInfo.setState(0);
        System.out.println(iUserInfoDao.registerMessage(userInfo));
    }


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

    @Test
    public void getUserInfo() throws Exception{
        List<UserInfo> list = iUserInfoDao.getUserInfoListByOnline("1");
        System.out.println(list);
    }

}