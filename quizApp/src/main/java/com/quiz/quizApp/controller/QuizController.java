package com.quiz.quizApp.controller;


import com.quiz.quizApp.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("questions")
public class QuizController {

    QuestionService serv=new QuestionService();

    @GetMapping("/all")
    public List<String> getAllQuestions(){
        return serv.getAllQuestions();
    }

}
