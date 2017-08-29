package com.interview.tracking.controller;

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

@RequestMapping("interview-tracking/interview")
@Controller
public class InterviewController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @GetMapping("/add")
    public String content(@RequestParam("userId") Long userId, Model model) {
        User user = userRepository.findOne(userId);
        if (user == null) {
            return "index";
        }

        Interview interview = new Interview();
        interview.setUserId(user.getId());

        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        return "addInterview";
    }

    @PostMapping("/add")
    public String addInterview(@ModelAttribute Interview interview, Model model) {
        interview.setUpdatedOn(new Date());
        interview = interviewRepository.save(interview);

        List<Interview> interviewList = interviewRepository.findAllByUserId(interview.getUserId());

        User user = userRepository.findOne(interview.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        model.addAttribute("interviewList", interviewList);
        return "searchUserResult";
    }


    @GetMapping("/edit")
    public String editInterview(@RequestParam("interviewId") Long interviewId, Model model) {
        Interview interview = interviewRepository.findOne(interviewId);
        if (interview == null) {
            return "index";
        }

        User user = userRepository.findOne(interview.getUserId());

        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        return "addInterview";
    }
}
