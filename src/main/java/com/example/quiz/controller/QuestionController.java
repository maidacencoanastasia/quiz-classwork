package com.example.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class QuestionController {
    @GetMapping("/questions")
    public String getQuestions(Model model) {
        return "questions";
    }
    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable int id,Model model) {
        model.addAttribute("id",id);
        return "question";
    }

}
