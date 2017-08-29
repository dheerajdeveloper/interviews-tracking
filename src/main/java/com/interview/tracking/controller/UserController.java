package com.interview.tracking.controller;

import com.interview.tracking.model.Interview;
import com.interview.tracking.model.User;
import com.interview.tracking.repository.InterviewRepository;
import com.interview.tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by dheeraj on 21/08/17.
 */

@RequestMapping("interview-tracking/user")
@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;


    @Autowired
    InterviewRepository interviewRepository;


    @GetMapping("getUserByEmailId")
    public String getUserByEmailId(@RequestParam("emailId") String emailId, Model model) {
        User user = userRepository.findFirstByEmailId(emailId);
        if (user == null) {
            return "index";
        }


        List<Interview> interviewList = interviewRepository.findAllByUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("interviewList", interviewList);
        return "searchUserResult";
    }

}
