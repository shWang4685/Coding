package com.service.Impl;

import com.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Value("${spring.mail.username}")
    private String from;

    /**
     * 异步发邮件
     * @param to
     * @param subject
     * @param content
     */
    @Override
    public void sendSimplemail(String to, String subject, String content) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = null;
                try {
                    helper = new MimeMessageHelper(message, true);
                    helper.setFrom(from);
                    helper.setTo(to);
                    helper.setSubject(subject);
                    helper.setText(content,true);
                    mailSender.send(message);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
