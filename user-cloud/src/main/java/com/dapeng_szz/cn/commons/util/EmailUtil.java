package com.dapeng_szz.cn.commons.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {


   /* @Autowired
    private JavaMailSender javaMailSender;

    public void contextLoads(String email,String msg,String title) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject(title);
        simpleMailMessage.setText(msg);
        simpleMailMessage.setFrom("1724368396@qq.com");
        simpleMailMessage.setTo(email);
        javaMailSender.send(simpleMailMessage);
    }*/
}
