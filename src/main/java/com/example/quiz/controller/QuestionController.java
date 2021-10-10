package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    private QuestionService  questionService;

    @GetMapping("/questions")
    public String getQuestions(Model model) {
        return "questions";
    }

    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "question";
    }

    // create REST API
    @PostMapping("")
    public ResponseEntity<Question> saveStudent(@RequestBody Question question) {
        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
    }

    // get REST API
    @GetMapping
    public List<Question> getAllStudents() {
        return questionService.getAllQuestions();
    }

    // get  by id REST API
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId) {
        return new ResponseEntity<Question>(questionService.getQuestionById(questionId), HttpStatus.OK);
    }

    // update REST API
    @PutMapping("/questions/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int questionId, @RequestBody Question question) {
        return new ResponseEntity<Question>(questionService.updateQuestion(question, questionId), HttpStatus.OK);
    }

    // delete REST API
    @DeleteMapping("/questions/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") int questionId) {
        questionService.deleteQuestion(questionId);
        return new ResponseEntity<String>("Question was successfully delete", HttpStatus.OK);
    }

}
