package com.example.quiz.controller;

import com.example.quiz.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
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
