package com.example.quiz.model;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "user_access")
public class UserAccess {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private LocalDateTime accessTime;
}
