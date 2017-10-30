package com.ws.spring.service.impl;

import com.ws.spring.dao.ISysPermissionDao;
import com.ws.spring.dao.ISysRoleDao;
import com.ws.spring.dao.IUserInfoDao;
import com.ws.spring.entity.PersonalInfo;
import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.IUserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleInfo;
import java.util.List;

@Service
public class UserInfoServiceImpl implements IUserInfoService {

    @Autowired
    private IUserInfoDao iUserInfoDao;

    @Autowired
    private ISysRoleDao iSysRoleDao;

    @Autowired
    private ISysPermissionDao iSysPermissionDao;

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

    @Override
    public Integer activateAccount(String username) {
        return iUserInfoDao.activateAccount(username);
    }

    @Override
    public PersonalInfo getPersonalInfo(String username) {
        UserInfo userInfo = iUserInfoDao.getUserInfoByUsername(username);
        SysRole sysRole = iSysRoleDao.getSysRoleByUid(userInfo.getId());
        List<SysPermission> sysPermission = iSysPermissionDao.getPermissionsByRoleId(sysRole.getId());
        PersonalInfo personalInfo = new PersonalInfo();
        BeanUtils.copyProperties(userInfo,personalInfo);
        personalInfo.setRole(sysRole.getRole());
        personalInfo.setPermission(sysPermission.get(0).getPermission());
        return personalInfo;
    }

    @Override
    public List<UserInfo> getUserInfoListByOnline(String online) {
        return iUserInfoDao.getUserInfoListByOnline(online);
    }
}
