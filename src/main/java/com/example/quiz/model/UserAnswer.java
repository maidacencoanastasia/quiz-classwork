package com.example.quiz.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users_answers")
public class UserAnswer {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name ="user_access_id")
    private UserAccess userAccess;

    @ManyToOne
    @JoinColumn(name ="question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name ="question_choice_id")
    private QuestionChoice questionChoice;
}
