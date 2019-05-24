package com.service;

import org.springframework.stereotype.Repository;

@Repository
public interface MailService {
     void sendSimplemail(String to, String subject, String content);
}
