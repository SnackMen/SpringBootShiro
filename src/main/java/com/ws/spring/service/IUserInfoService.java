package com.ws.spring.service;

import com.ws.spring.entity.PersonalInfo;
import com.ws.spring.entity.UserInfo;
import org.springframework.stereotype.Service;
import java.util.List;


public interface IUserInfoService {
    List<UserInfo> getAll();

    UserInfo getUserById(Integer id);

    String getPasswordByUserName(String username);

    Integer registerMessage(UserInfo userInfo);

    Integer activateAccount(String username);

    PersonalInfo getPersonalInfo(String username);

    List<UserInfo> getUserInfoListByOnline(String online);
}
