package com.quiz.quizApp.controller;


import com.quiz.quizApp.model.Question;
import com.quiz.quizApp.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizapp/questions")
public class QuestionController {

    @Autowired
    QuestionService serv;

    @GetMapping("/all")
    public List<Question> getAllQuestions(){
        return serv.getAllQuestions();
    }

    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
        return serv.addQuestion(question);
    }

    @GetMapping("/category/{category}")
    public  List<Question> getQuestionByCategory(@PathVariable String category){
        return  serv.getQuestionsByCategory(category);
    }

}
