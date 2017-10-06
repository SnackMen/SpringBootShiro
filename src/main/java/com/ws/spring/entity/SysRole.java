package com.ws.spring.entity;

import java.io.Serializable;
import java.util.List;

public class SysRole implements Serializable {

    private static final Long serialVersionUID = 1L;

    private Integer id;

    private Integer available;

    private String description;

    private String role;

    private List<UserInfo> userInfoList;

    private List<SysPermission> sysPermissionList;

    public SysRole(){
        super();
    }

    public SysRole(Integer id, Integer available, String role){
        this.id = id;
        this.available = available;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public List<SysPermission> getSysPermissionList() {
        return sysPermissionList;
    }

    public void setSysPermissionList(List<SysPermission> sysPermissionList) {
        this.sysPermissionList = sysPermissionList;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "id=" + id +
                ", available=" + available +
                ", description='" + description + '\'' +
                ", role='" + role + '\'' +
                ", userInfoList=" + userInfoList +
                ", sysPermissionList=" + sysPermissionList +
                '}';
    }
}
