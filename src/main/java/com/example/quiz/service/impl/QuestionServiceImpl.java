package com.example.quiz.service.impl;

import com.example.quiz.exception.ResourceNotFoundException;
import com.example.quiz.model.Question;
import com.example.quiz.repository.QuestionRepository;
import com.example.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class QuestionServiceImpl implements QuestionService {
    private QuestionRepository questionRepository;

    @Override
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public Question getQuestionById(int id) {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new ResourceNotFoundException("Id", "Question", id);
        }
    }

    @Override
    public Question updateQuestion(Question question, int id) {
        Question existingQuestion = questionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Question", "ID", id)
        );
        existingQuestion.setText(question.getText());
        questionRepository.save(existingQuestion);
        return existingQuestion;
    }

    @Override
    public void deleteQuestion(int id) {
        questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question", "ID", id));
        questionRepository.deleteById(id);
    }
}
