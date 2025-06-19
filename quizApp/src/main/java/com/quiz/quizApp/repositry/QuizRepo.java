package com.quiz.quizApp.repositry;

import com.quiz.quizApp.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
