package com.interview.tracking.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.interview.tracking.model.Interview;
import com.interview.tracking.model.User;
import com.interview.tracking.repository.InterviewRepository;
import com.interview.tracking.repository.InterviewRoundRepository;
import com.interview.tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by dheeraj on 21/08/17.
 */

@RequestMapping("interview-tracking")
@Controller
public class ApiController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @GetMapping("/admin/adduser")
    public String content(Model model) {
        User user = new User();

        model.addAttribute("user", user);
        return "admin";
    }

    @PostMapping("admin/user/add")
    public String addUser(@ModelAttribute User user) {
        user.setCreatedOn(new Date());
        user.setUpdatedOn(new Date());
        user = userRepository.save(user);
        return "userSaveResult";
    }

    @GetMapping("searchUser")
    public String searchUser(@RequestParam("userId") Long id, Model model) {

        User user = userRepository.findOne(id);

        if(user == null){
            return "index";
        }

        List<Interview> interviewList = interviewRepository.findAllByUserId(id);

        model.addAttribute("user", user);
        model.addAttribute("interviewList", interviewList);
        return "searchUserResult";
    }
}
