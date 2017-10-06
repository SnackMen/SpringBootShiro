package com.ws.spring.service.impl;

import com.ws.spring.dao.ShiroSampleDao;
import com.ws.spring.service.IShiroSampleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class ShiroSampleServiceImpl implements IShiroSampleService {

    @Autowired
    private ShiroSampleDao shiroSampleDao;

    @Override
    public Set<String> getRolesByUserName(String username) {
        return shiroSampleDao.getRolesByUserName(username);
    }

    @Override
    public Set<String> getPermissionsByRole(String role) {
        return shiroSampleDao.getPermissionsByRole(role);
    }
}
