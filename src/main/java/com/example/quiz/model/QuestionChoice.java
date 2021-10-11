package com.example.quiz.model;

import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
@Data
@Entity
@Table(name = "questionChoices")
public class QuestionChoice {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    private boolean correct;
    private String text;

}
