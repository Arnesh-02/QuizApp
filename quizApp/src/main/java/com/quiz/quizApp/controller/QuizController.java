package com.quiz.quizApp.controller;


import com.quiz.quizApp.dao.QuestionDao;
import com.quiz.quizApp.dao.ResponseDao;
import com.quiz.quizApp.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizapp/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("new")
    public String createQuiz(@RequestParam String category,@RequestParam String title,@RequestParam Integer no){
        return quizService.createQuiz(category,title,no);
    }

    @GetMapping("get/{id}")
    public List<QuestionDao> getAllQuestionByQuizId(@PathVariable Integer id){
        return  quizService.getAllQuestionByQuizId(id);
    }

    @PostMapping("submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id,@RequestBody List<ResponseDao> responses){
        return  quizService.calculateScore(id,responses);
    }

}
