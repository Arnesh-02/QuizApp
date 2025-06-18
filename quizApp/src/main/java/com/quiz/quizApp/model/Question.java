package com.quiz.quizApp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.naming.Name;

@Entity
@Table(name = "Question")
public class Question {
    @Id
    int qnNo;


}
