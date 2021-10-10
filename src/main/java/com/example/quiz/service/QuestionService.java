package com.example.quiz.service;

import com.example.quiz.model.Question;

import java.util.List;

public interface QuestionService {
    Question saveQuestion(Question question);

    List<Question> getAllQuestion();

    Question getQuestionById(int id);

    Question updateQuestion(Question question, int id);

    void deleteQuestion(int id);
}
