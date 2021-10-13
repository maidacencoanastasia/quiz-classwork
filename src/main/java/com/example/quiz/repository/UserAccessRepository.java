package com.example.quiz.repository;

import com.example.quiz.model.Question;
import com.example.quiz.model.UserAccess;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccessRepository extends JpaRepository<UserAccess, Integer> {

}
