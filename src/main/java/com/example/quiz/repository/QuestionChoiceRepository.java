package com.example.quiz.repository;

import com.example.quiz.model.QuestionChoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionChoiceRepository extends JpaRepository<QuestionChoice, Integer> {
}
