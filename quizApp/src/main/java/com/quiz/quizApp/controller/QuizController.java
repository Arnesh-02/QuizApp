package com.quiz.quizApp.controller;


import com.quiz.quizApp.model.Quiz;
import com.quiz.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quizapp/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("new")
    public String createQuiz(@RequestParam String category,@RequestParam String title,@RequestParam Integer no){
        return quizService.createQuiz(category,title,no);
    }

}
