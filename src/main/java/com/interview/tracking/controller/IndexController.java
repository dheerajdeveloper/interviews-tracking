package com.interview.tracking.controller;

import com.interview.tracking.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    UserController userController;

    @RequestMapping("/")
    public String content(Model model, Principal principal) {
        if (principal == null || principal.getName() == null) {
            return "login";
        }
        String emailid = principal.getName();

        return userController.getUserByEmailId(emailid, model);

    }

}
