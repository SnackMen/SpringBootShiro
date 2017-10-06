package com.ws.spring.service;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface IShiroSampleService {

    Set<String> getRolesByUserName(String username);

    Set<String> getPermissionsByRole(String role);

}
