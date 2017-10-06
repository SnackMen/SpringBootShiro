package com.ws.spring.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.ISysRoleAndPermissionService;
import com.ws.spring.service.IUserInfoService;
import com.ws.spring.util.DataTablePageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * 请求返回类型都是Json类型
 */
@RestController
@RequestMapping("/userJson")
public class UserJsonController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private ISysRoleAndPermissionService iSysRoleAndPermissionService;


    @PostMapping("/userMessage")
    public DataTablePageUtil<UserInfo> getUserMessage(HttpServletRequest request){
        DataTablePageUtil<UserInfo> dataTable = new DataTablePageUtil<>(request);
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        List<UserInfo> list = iUserInfoService.getAll();
        PageInfo<UserInfo> pageInfo = new PageInfo<>(list);
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int)pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        return dataTable;
    }

    @PostMapping("/roleMessage")
    public DataTablePageUtil<SysRole> getRoleMessage(HttpServletRequest request){
        DataTablePageUtil<SysRole> dataTable = new DataTablePageUtil<>(request);
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        List<SysRole> list = iSysRoleAndPermissionService.getAllRoles();
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int)pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        return dataTable;
    }

    @PostMapping("/permissionMessage")
    public DataTablePageUtil<SysPermission> getPermissionMessage(HttpServletRequest request){
        DataTablePageUtil<SysPermission> dataTable = new DataTablePageUtil<>(request);
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        List<SysPermission> list = iSysRoleAndPermissionService.getAllPermissions();
        PageInfo<SysPermission> pageInfo = new PageInfo<>(list);
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int)pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        return dataTable;
    }

    /**
     * 规定一个用户只有一个角色，但是一个角色拥有多个用户，所以通过用户id查询，永远只有一个角色
     * @param session
     * @return
     */
    @PostMapping("/userRole")
    public DataTablePageUtil<SysRole> getUserRole(HttpSession session,HttpServletRequest request){
        DataTablePageUtil<SysRole> dataTable = new DataTablePageUtil<>(request);
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        List<SysRole> list = new ArrayList<>();
        list.add(iSysRoleAndPermissionService.getUserRoleByUsername(session.getAttribute("username").toString()));
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int)pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        return dataTable;
    }

    /**
     * 一个用户只有一个角色，一个角色有多个权限，一个权限有多个角色
     * @param session
     * @return
     */
    @PostMapping("/rolePermission")
    public DataTablePageUtil<SysRole> getRolePermission(HttpSession session, HttpServletRequest request){
        DataTablePageUtil<SysRole> dataTable = new DataTablePageUtil<>(request);
        PageHelper.startPage(dataTable.getPage_num(), dataTable.getPage_size());
        List<SysRole> list = new ArrayList<>();
        list.add(iSysRoleAndPermissionService.getRolePermissionByUsername(session.getAttribute("username").toString()));
        PageInfo<SysRole> pageInfo = new PageInfo<>(list);
        dataTable.setDraw(dataTable.getDraw());
        dataTable.setData(pageInfo.getList());
        dataTable.setRecordsTotal((int)pageInfo.getTotal());
        dataTable.setRecordsFiltered(dataTable.getRecordsTotal());
        return dataTable;
    }

}
