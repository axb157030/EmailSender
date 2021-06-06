package com.email.sender.service.impl;

import com.email.sender.model.EmailConfig;
import com.email.sender.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public String getEmails() {
        return null;
    }

    @Override
    public String setEmailConfig(EmailConfig emailConfig) {
        return null;
    }

    @Override
    public String sendEmails() throws MessagingException {
        // Read .cvs file to find email and respective names
        String path = "";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("Some email");
        helper.setText("<html><body><p>Test!</p><body></html>", true);
        FileSystemResource file  = new FileSystemResource(new File(path));
        helper.addAttachment("testfile", file);
        helper.setSubject("EPICTestEmail");
        javaMailSender.send(message);
        return "success";
        // https://stackoverflow.com/questions/24981052/send-mailmessage-to-send-different-attachments-to-different-recipients
        // https://aws.amazon.com/secrets-manager/
    }
}
