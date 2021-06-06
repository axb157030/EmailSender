package com.email.sender.service.impl;

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
    public String sendEmails() throws MessagingException {
        String path = "C:\\Users\\amine\\OneDrive\\Documents\\Spring\\epic\\CourseCertificatesamine-benelbar-tableau-course.jpg";
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo("amine.benelbar.1@gmail.com");
        helper.setText("<html><body><p>Test!</p><body></html>", true);
        FileSystemResource file  = new FileSystemResource(new File(path));
        helper.addAttachment("testfile", file);
        helper.setSubject("EPICTestEmail");
        javaMailSender.send(message);
        return "success";
    }
}
