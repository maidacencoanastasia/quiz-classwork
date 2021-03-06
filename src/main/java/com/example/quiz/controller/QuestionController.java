package com.example.quiz.controller;

import com.example.quiz.model.Question;
import com.example.quiz.model.UserAccess;
import com.example.quiz.model.UserAnswer;
import com.example.quiz.repository.QuestionChoiceRepository;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.repository.UserAccessRepository;
import com.example.quiz.repository.UserAnswerRepository;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

//@RestController
@Controller
@RequestMapping("questions")
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;
    private QuestionService questionService;
    private UserAccessRepository userAccessRepository;
    private UserAnswerRepository userAnswerRepository;
    private QuestionChoiceRepository questionChoiceRepository;

    public QuestionController(UserAccessRepository userAccessRepository) {
        this.userAccessRepository = userAccessRepository;
    }

    //    @PostConstruct
//    public  void init(){
//        Question question = new Question();
//    }
    @GetMapping("/view-next-question")
    public String viewQuestion(@RequestParam(required = false) Integer id, @RequestParam int userAccessId, Model model) throws Exception {
        UserAccess userAccess = userAccessRepository.findById(userAccessId)
                .orElseThrow(() -> new Exception(" No user access row found"));
        Question question;
        if (id!=null){
            question = questionRepository.findTop1ByIdGreaterThanOrderByIdAsc(id);
        }else{
            question = questionRepository.findTop1ByOrderByIdAsc();
        }
        model.addAttribute("user_Access", userAccess);
        model.addAttribute("question",question);
        return "question";

    }

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
    public String PostQuestion(UserAnswerForm form) {
        System.out.println("123");
        return "redirect:/questions/question/1";
    }

//    @PostMapping("/submit-question-answer")
//    public String submitUserAnswer(UserAnswerForm form, @RequestParam int userAccessId) throws Exception {
//        UserAccess userAccess = userAccessRepository.findById(userAccessId)
//                .orElseThrow(() -> new Exception(" No user access row found"));
//
//        //some problems form.getQuestion()
//        Question question = questionRepository.findById(form.getQuestion()).get();
//        UserAnswer userAnswer = new UserAnswer();
//        userAnswer.setUserAccess(userAccess);
//        userAnswer.setQuestion(question);
//        userAnswer.setQuestionChoice(questionChoiceRepository.findById(form.getChoice()).get());
//        userAnswerRepository.save(userAnswer);
//        return "redirect:/questions/view-next-question?userAccessId"+ userAccess.getId() +"&id="+question.getId();
//    }

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
    // get  by id REST API
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable("id") int questionId) {
        return new ResponseEntity<Question>(questionService.getQuestionById(questionId), HttpStatus.OK);
    }
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
