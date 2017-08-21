package com.interview.tracking.controller;

import com.interview.tracking.model.User;
import com.interview.tracking.repository.InterviewRepository;
import com.interview.tracking.repository.InterviewRoundRepository;
import com.interview.tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by dheeraj on 21/08/17.
 */

@RequestMapping("")
@Controller
public class ApiController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    InterviewRoundRepository interviewRoundRepository;

    @GetMapping("/user/add")
    public String addUser(Model model){
        User user = new User();

        model.addAttribute("user" , user);
        return "useradd";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user){
        user.setCreatedOn(new Date());
        user.setUpdatedOn(new Date());
        user = userRepository.save(user);
        return "userSaveResult";
    }

//    @PostMapping("/interview/add")
//    public Interview addInterview(@ModelAttribute Interview interview){
//        return interviewRepository.save(interview);
//    }
//
//    @PostMapping("/interviewround/add")
//    public InterviewRound addInterview(@ModelAttribute InterviewRound interviewRound){
//        return interviewRoundRepository.save(interviewRound);
//    }


}
