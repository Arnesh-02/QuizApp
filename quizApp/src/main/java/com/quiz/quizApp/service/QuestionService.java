package com.quiz.quizApp.service;


import com.quiz.quizApp.model.Question;
import com.quiz.quizApp.repositry.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;


    public List<Question> getAllQuestions() {
        return questionRepo.findAll();
    }

    public String addQuestion(Question question) {
        questionRepo.save(question);
        return "Question Added Successfully..!";
    }

    public List<Question> getQuestionsByCategory(String category){
        return  questionRepo.findByCategory(category);
    }
}
