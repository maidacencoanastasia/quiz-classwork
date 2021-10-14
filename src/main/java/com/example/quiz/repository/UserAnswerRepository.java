package com.example.quiz.repository;

import com.example.quiz.model.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {
}
