package com.example.quiz.controller;

import com.example.quiz.model.UserAccess;
import com.example.quiz.repository.UserAccessRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Controller
public class QuizController {

    private UserAccessRepository userAccessRepository;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/start")
    public  String start(@RequestParam String user, Model model){
        UserAccess userAccess = new UserAccess();
        userAccess.setName(user);
        userAccess.setAccessTime(LocalDateTime.now());
        userAccessRepository.save(userAccess);
    return "redirect:/questions/view-next-question?userAccessId"+ userAccess.getId();
    }
}
