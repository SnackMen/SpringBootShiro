package com.ws.spring.util;

import com.ws.spring.service.MailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import static org.junit.Assert.*;

public class SendMailUtilTest {

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private MailService mailService;

    @Test
    public void sendHtmlMail() throws Exception {

        Context context = new Context();
        context.setVariable("id","007");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("vipkia@sina.cn", "主题：这是模板邮件", emailContent);
        System.out.println("发送邮件成功！");

    }

}