package com.example.quiz.controller;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_answer")
public class UserAnswerForm {
    @Id
    @GeneratedValue
    private int id;
    private int choice;
}
