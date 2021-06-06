package com.email.sender.service;

import javax.mail.MessagingException;

public interface EmailService {

    public String getEmails();
    public String sendEmails() throws MessagingException;
}
