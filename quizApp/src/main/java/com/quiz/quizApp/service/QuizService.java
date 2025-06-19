package com.quiz.quizApp.service;

import com.quiz.quizApp.model.Question;
import com.quiz.quizApp.model.Quiz;
import com.quiz.quizApp.repositry.QuestionRepo;
import com.quiz.quizApp.repositry.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

   @Autowired
    QuizRepo quizRepo;

    @Autowired
    QuestionRepo questionRepo;


    public String createQuiz(String category, String title, Integer no) {
        Quiz quiz=new Quiz();
        List<Question> questions=questionRepo.findRandomQuestionsByCategory(category,no);
        quiz.setQuestions(questions);
        quiz.setTitle(title);
        quizRepo.save(quiz);
        return "Quiz created successfully";
    }
}
