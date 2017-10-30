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
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;

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

    @RequestMapping("/forgetpassword")
    public String changePassword(){
        return "forgetPassword";
    }


    @RequestMapping(value = "/forgetPassword",method = RequestMethod.POST)
    public void getValidateCode(HttpServletRequest request)throws Exception {
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        String capstr = hash1.substring(0, 4);
        HttpSession session = request.getSession();
        session.setAttribute("validateCode", capstr);
        //需要先判断账号对应的邮箱是否存在，账号是否存在，这里前端框架应该是有的，所以暂时不处理
        Context context = new Context();
        context.setVariable("validateCode", capstr);
        String emailContent = templateEngine.process("changePasswordTemplate", context);
        System.out.println(request.getParameter("email"));
        mailService.sendHtmlMail(request.getParameter("email"), "找回密码", emailContent);
        System.out.println("发送邮件成功！");
    }
}
