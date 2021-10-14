package com.example.quiz.controller;

import com.example.quiz.model.Question;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "user_answer")
public class UserAnswerForm {
    @Id
    @GeneratedValue
    private int id;
    private int choice;

    @OneToOne
    @JoinColumn(name = "question_id")
    private Question question;
}
