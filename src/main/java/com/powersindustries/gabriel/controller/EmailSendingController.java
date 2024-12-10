package com.powersindustries.gabriel.controller;

import com.powersindustries.gabriel.model.User;
import com.powersindustries.gabriel.service.EmailSendingService;
import com.powersindustries.gabriel.service.UserService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmailSendingController {

    private final EmailSendingService emailSendingService;
    private final UserService userService;

    public EmailSendingController(EmailSendingService emailSendingService, UserService userService) {
        this.emailSendingService = emailSendingService;
        this.userService = userService;

        // ToDo: This block is for POC. Move to endpoint.
        List<User> userList = userService.getAllUsers();
        for (User user : userList) {
            emailSendingService.sendEmail(user.getEmail(), "Test", "Test message.");
        }
    }
}
