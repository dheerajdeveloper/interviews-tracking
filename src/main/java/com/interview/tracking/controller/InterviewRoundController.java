package com.interview.tracking.controller;

import com.interview.tracking.model.Interview;
import com.interview.tracking.model.InterviewRound;
import com.interview.tracking.model.User;
import com.interview.tracking.repository.InterviewRepository;
import com.interview.tracking.repository.InterviewRoundRepository;
import com.interview.tracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dheeraj on 21/08/17.
 */

@RequestMapping("interview-tracking/interview-round")
@Controller
public class InterviewRoundController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    InterviewRepository interviewRepository;

    @Autowired
    InterviewRoundRepository interviewRoundRepository;


    @GetMapping("/add")
    public String content(@RequestParam("interviewId") Long interviewId, Model model) {
        Interview interview = interviewRepository.findOne(interviewId);
        if (interview == null) {
            return "index";
        }

        InterviewRound interviewRound = new InterviewRound();
        interviewRound.setInterviewId(interviewId);

        User user = userRepository.findOne(interview.getUserId());
        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        model.addAttribute("interviewRound", interviewRound);

        return "addInterviewRound";
    }


    @PostMapping("/add")
    public String addInterviewRound(@ModelAttribute InterviewRound interviewRound, Model model) {
        interviewRound = interviewRoundRepository.save(interviewRound);

        List<InterviewRound> interviewRoundList =
                interviewRoundRepository.findAllByInterviewId(interviewRound.getInterviewId());


        Interview interview = interviewRepository.findOne(interviewRound.getInterviewId());
        User user = userRepository.findOne(interview.getUserId());

        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        model.addAttribute("interviewRoundList", interviewRoundList);
        return "interviewRoundSearchResult";
    }


    @GetMapping("/get")
    public String getInterviewRounds(@RequestParam("interviewId") Long interviewId, Model model) {
        Interview interview = interviewRepository.findOne(interviewId);
        if (interview == null) {
            return "index";
        }
        User user = userRepository.findOne(interview.getUserId());
        List<InterviewRound> interviewRoundList = interviewRoundRepository.findAllByInterviewId(interviewId);

        model.addAttribute("user", user);
        model.addAttribute("interview", interview);
        model.addAttribute("interviewRoundList", interviewRoundList);
        return "interviewRoundSearchResult";
    }

}
