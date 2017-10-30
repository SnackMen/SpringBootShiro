package com.ws.spring.controller;

import com.ws.spring.entity.PersonalInfo;
import com.ws.spring.entity.UserInfo;
import com.ws.spring.service.IUserInfoService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Random;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    IUserInfoService iUserInfoService;

    @RequestMapping({"/", "/index"})
    public String index() {
//        return "index";
        return "userInfo";
    }


    @RequestMapping("/login")
    public String loginForm(HttpServletRequest request) {
        if (request.getRemoteUser() != null) {
            return "redirect:/user/userInfo";
        }

        return "login";
    }

    @RequestMapping("/403")
    public String unauthorizedRole() {
        System.out.println("------没有权限-------");
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Map<String, Object> map) throws Exception {
        request.getSession().setAttribute("username", request.getParameter("username"));
        System.out.println("session:" + request.getSession().getAttribute("username"));
        String exception = (String) request.getAttribute("shiroLoginFailure");
        String msg = "";
        if (exception != null) {
            if (UnknownAccountException.class.getName().equals(exception)) {
                System.out.println("UnknownAccountException -- > 账号不存在：");
                msg = "UnknownAccountException -- > 账号不存在：";
            } else if (IncorrectCredentialsException.class.getName().equals(exception)) {
                System.out.println("IncorrectCredentialsException -- > 密码不正确：");
                msg = "IncorrectCredentialsException -- > 密码不正确：";
            } else if ("kaptchaValidateFailed".equals(exception)) {
                System.out.println("kaptchaValidateFailed -- > 验证码错误");
                msg = "kaptchaValidateFailed -- > 验证码错误";
            } else {
                msg = "else >> " + exception;
                System.out.println("else -- >" + exception);
            }
        }
        map.put("msg", msg);
        return "login";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logOut() {
        return "login";
    }

    @RequestMapping("/validatecode")
    public void getKaptchaImage(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        int width = 60;
        int height = 32;
        //create the image
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        // set the background color
        g.setColor(new Color(0xDCDCDC));
        g.fillRect(0, 0, width, height);
        // draw the border
        g.setColor(Color.black);
        g.drawRect(0, 0, width - 1, height - 1);
        // create a random instance to generate the codes
        Random rdm = new Random();
        String hash1 = Integer.toHexString(rdm.nextInt());
        // make some confusion
        for (int i = 0; i < 50; i++) {
            int x = rdm.nextInt(width);
            int y = rdm.nextInt(height);
            g.drawOval(x, y, 0, 0);
        }
        // generate a random code
        String capstr = hash1.substring(0, 4);
        HttpSession session = req.getSession(true);
        //将生成的验证码存入session
        session.setAttribute("validateCode", capstr);
        g.setColor(new Color(0, 100, 0));
        g.setFont(new Font("Candara", Font.BOLD, 24));
        g.drawString(capstr, 8, 24);
        g.dispose();
        //输出图片
        resp.setContentType("image/jpeg");
        OutputStream strm = resp.getOutputStream();
        ImageIO.write(image, "jpeg", strm);
        strm.close();
    }

    @RequestMapping("/personal")
    public String getPersonalPage(HttpServletRequest request, Map<String, Object> map) throws Exception{
        List<UserInfo> userInfoList = iUserInfoService.getUserInfoListByOnline("1");
        String username = request.getSession().getAttribute("username").toString();
        PersonalInfo personalInfo = iUserInfoService.getPersonalInfo(username);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("personalInfo", personalInfo);
        map.put("registerTime",simpleDateFormat.format(personalInfo.getRegisterTime()));
        map.put("lastLoginTime",simpleDateFormat.format(personalInfo.getLastLoginTime()));
        map.put("userInfoList",userInfoList);
        return "personal";
    }
}