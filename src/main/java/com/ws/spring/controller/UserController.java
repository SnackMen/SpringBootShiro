package com.ws.spring.controller;

import com.ws.spring.entity.SysPermission;
import com.ws.spring.entity.SysRole;
import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.ISysRoleAndPermissionService;
import com.ws.spring.service.IUserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


//@RestController
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private ISysRoleAndPermissionService iSysRoleAndPermissionService;


    @RequestMapping("/userInfo")
    public String getUserInfo(ModelMap modelMap){
        List<UserInfo> list = iUserInfoService.getAll();
        modelMap.addAttribute("userList", list);
        return "userInfo";
    }

    @RequestMapping("/userJson/userInfo")
    public String getUserInfoJson(ModelMap modelMap){
        List<UserInfo> list = iUserInfoService.getAll();
        modelMap.addAttribute("userList", list);
        return "userInfoJson";
    }

    @PostMapping("/userMessage")
    public String getUserMessage(ModelMap modelMap){
        List<UserInfo> list = iUserInfoService.getAll();
        modelMap.addAttribute("userList", list);
        return "userMessage";
    }

    @PostMapping("/roleMessage")
    public String getRoleMessage(ModelMap modelMap){
        List<SysRole> list = iSysRoleAndPermissionService.getAllRoles();
        modelMap.addAttribute("roleList", list);
        return "roleMessage";
    }

    @PostMapping("/permissionMessage")
    public String getPermissionMessage(ModelMap modelMap){
        List<SysPermission> listSysPermission = iSysRoleAndPermissionService.getAllPermissions();
        modelMap.addAttribute("permissionList", listSysPermission);
        return "permissionMessage";
    }

    /**
     * 规定一个用户只有一个角色，但是一个角色拥有多个用户，所以通过用户id查询，永远只有一个角色
     * @param modelMap
     * @param session
     * @return
     */

    @PostMapping("/userRole")
    @RequiresRoles(value={"admin"})
    public String getUserRole(ModelMap modelMap, HttpSession session){
//        SysRole sysRole = iSysRoleAndPermissionService.getUserRoleByUsername(session.getAttribute("username").toString());
        List<SysRole> list = iSysRoleAndPermissionService.getRoleUserInfo();
        modelMap.addAttribute("userRoleList", list);
        return "userRole";
    }

    /**
     * 一个用户只有一个角色，一个角色有多个权限，一个权限有多个角色
     * @param modelMap
     * @param session
     * @return
     */
    @PostMapping("/rolePermission")
    @RequiresPermissions("userInfo:add")
    public String getRolePermission(ModelMap modelMap, HttpSession session){
//        SysRole sysRole = iSysRoleAndPermissionService.getRolePermissionByUsername(session.getAttribute("username").toString());
        List<SysRole> list = iSysRoleAndPermissionService.getRolePermissionInfo();
        modelMap.addAttribute("rolePermissionList", list);
        return "rolePermission";
    }

}
