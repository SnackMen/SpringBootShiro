package com.ws.spring.controller;

import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.IUserInfoService;
import com.ws.spring.util.MD5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @RequestMapping("/register")
    public String register(){
        return "register";
    }


    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, Map<String, Object> map){

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(request.getParameter("username"));
        userInfo.setPassword(MD5Password.md5Entry(request.getParameter("password")));
        userInfo.setSalt(MD5Password.md5Entry(request.getParameter("password")));
        userInfo.setName(request.getParameter("name"));
        userInfo.setEmail(request.getParameter("email"));
        userInfo.setState(0);
        int count = iUserInfoService.registerMessage(userInfo);
        map.put("name",userInfo.getName());
        if(count > 0)
            return "successRegister";
        else
            return "errorRegister";
    }
}
