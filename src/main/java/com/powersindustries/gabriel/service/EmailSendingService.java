package com.powersindustries.gabriel.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailSendingService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendtTextEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);

        mailSender.send(message);
    }

    public void sendtHTMLEmail(String to, String subject, String html) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);

        mailSender.send(message);
    }

}
