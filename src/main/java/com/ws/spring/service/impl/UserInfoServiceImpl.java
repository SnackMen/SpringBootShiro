package com.ws.spring.service.impl;

import com.ws.spring.dao.IUserInfoDao;
import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao iUserInfoDao;


    @Override
    public List<UserInfo> getAll() {
        return iUserInfoDao.getAll();
    }

    @Override
    public UserInfo getUserById(Integer id) {
        return iUserInfoDao.getUserById(id);
    }

    @Override
    public String getPasswordByUserName(String username) {
        return iUserInfoDao.getPasswordByUserName(username);
    }

    @Override
    public Integer registerMessage(UserInfo userInfo) {
        return iUserInfoDao.registerMessage(userInfo);
    }
}
