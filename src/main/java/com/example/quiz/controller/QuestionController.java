package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

//@RestController
@Controller
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

//    private QuestionService  questionService;

//    @PostConstruct
//    public  void init(){
//        Question question = new Question();
//    }

    @GetMapping("/questions")
    public String getQuestions(Model model) {
        return "questions";
    }
    @Transactional(readOnly = true)
    @GetMapping("/question/{id}")
    public String getQuestion(@PathVariable int id, Model model) {
        Question question = questionRepository.findById(id).get();
        model.addAttribute("question", question);
        return "question";
    }

    @PostMapping("/question")
    public String PostQuestion(UserAnswerForm form){
        System.out.println("123");
        return "redirect:/questions/question/1";
    }






    // create REST API
//    @PostMapping("")
//    public ResponseEntity<Question> saveQuestion(@RequestBody Question question) {
//        return new ResponseEntity<>(questionService.saveQuestion(question), HttpStatus.CREATED);
//    }

//    // get REST API
//    @GetMapping
//    public List<Question> getAllQuestions() {
//        return questionService.getAllQuestions();
//    }
//
//    // get  by id REST API
//    @GetMapping("/questions/{id}")
//    public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId) {
//        return new ResponseEntity<Question>(questionService.getQuestionById(questionId), HttpStatus.OK);
//    }
//
//    // update REST API
//    @PutMapping("/questions/{id}")
//    public ResponseEntity<Question> updateQuestion(@PathVariable("id") int questionId, @RequestBody Question question) {
//        return new ResponseEntity<Question>(questionService.updateQuestion(question, questionId), HttpStatus.OK);
//    }
//
//    // delete REST API
//    @DeleteMapping("/questions/{id}")
//    public ResponseEntity<String> deleteQuestion(@PathVariable("id") int questionId) {
//        questionService.deleteQuestion(questionId);
//        return new ResponseEntity<String>("Question was successfully delete", HttpStatus.OK);
//    }

}
