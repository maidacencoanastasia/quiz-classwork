package com.example.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/start")
    public  String start(){
    return "redirect";
    }
}
