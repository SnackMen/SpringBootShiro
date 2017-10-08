package com.ws.spring.service;

public interface MailService {

    void sendHtmlMail(String to, String subject, String content);

}
