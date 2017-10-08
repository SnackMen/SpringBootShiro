package com.ws.spring.controller;

import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.IUserInfoService;
import com.ws.spring.service.MailService;
import com.ws.spring.util.MD5Password;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class RegisterController {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

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

        Context context = new Context();
        context.setVariable("username",userInfo.getUsername());
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail(userInfo.getEmail(), "账号激活", emailContent);
        System.out.println("发送邮件成功！");

        map.put("name",userInfo.getName());
        if(count > 0)
            return "successRegister";
        else
            return "errorRegister";

    }

    @RequestMapping("/activation")
    public String activateAccount(HttpServletRequest request){
        String username = request.getParameter("username");
        int count =  iUserInfoService.activateAccount(username);
        if (count > 0)
            return "login";
        else
            return "register";
    }

}
