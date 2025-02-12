package com.powersindustries.gabriel.controller;

import com.powersindustries.gabriel.model.User;
import com.powersindustries.gabriel.service.EmailContentRenderingService;
import com.powersindustries.gabriel.service.EmailSendingService;
import com.powersindustries.gabriel.service.UserService;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmailSendingController {

    private final EmailSendingService emailSendingService;
    private final UserService userService;
    private final EmailContentRenderingService emailContentRenderingService;

    public EmailSendingController(EmailSendingService emailSendingService, UserService userService, EmailContentRenderingService emailContentRenderingService) throws MessagingException {
        this.emailSendingService = emailSendingService;
        this.userService = userService;
        this.emailContentRenderingService = emailContentRenderingService;

        // ToDo: This block is for POC. Moving to endpoint in the future.
        List<User> userList = this.userService.getAllUsers();
        for (User user : userList) {
            this.emailSendingService.sendtTextEmail(user.getEmail(), "Test", "Test message.");

            String html = this.emailContentRenderingService.getBodyTestHTML().getHtml();
            this.emailSendingService.sendtHTMLEmail(user.getEmail(), "Test html", html);

            String markdown = this.emailContentRenderingService.getBodyTestMarkdown().getHtml();
            this.emailSendingService.sendtHTMLEmail(user.getEmail(), "Test Markdown", markdown);
        }
    }
}
