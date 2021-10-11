package com.example.quiz.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "text")
    private String text;
    @ToString.Exclude
    @OneToMany(mappedBy = "question")
    private List<QuestionChoice> choices;

}
