package com.email.sender.service;

import com.email.sender.model.EmailConfig;

import javax.mail.MessagingException;

public interface EmailService {

    public String getEmails();
    public String setEmailConfig(EmailConfig emailConfig);
    public String sendEmails() throws MessagingException;
}
