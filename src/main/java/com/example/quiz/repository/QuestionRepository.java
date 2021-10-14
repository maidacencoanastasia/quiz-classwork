package com.example.quiz.repository;

import com.example.quiz.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    Question findTop1ByOrderByIdAsc();
    Question findTop1ByIdGreaterThanOrderByIdAsc(int id);

}
