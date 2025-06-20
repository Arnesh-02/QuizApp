package com.quiz.quizApp.service;

import com.quiz.quizApp.dao.QuestionDao;
import com.quiz.quizApp.dao.ResponseDao;
import com.quiz.quizApp.model.Question;
import com.quiz.quizApp.model.Quiz;
import com.quiz.quizApp.repositry.QuestionRepo;
import com.quiz.quizApp.repositry.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<QuestionDao> getAllQuestionByQuizId(Integer id) {
        Optional<Quiz> quiz=quizRepo.findById(id);
        List<Question> questionsForCreator=quiz.get().getQuestions();
        List<QuestionDao> questionDaoList=new ArrayList<>();
        for(Question i : questionsForCreator){
            QuestionDao questionDao=new QuestionDao();
            questionDao.setQuestion(i.getQuestion());
            questionDao.setQnNo(i.getQnNo());
            questionDao.setLevel(i.getLevel());
            questionDao.setOption1(i.getOption1());
            questionDao.setOption2(i.getOption2());
            questionDao.setOption3(i.getOption3());
            questionDao.setOption4(i.getOption4());

            questionDaoList.add(questionDao);
        }
        return  questionDaoList;
    }

    public Integer calculateScore(Integer quizNo, List<ResponseDao> responses) {
        Quiz quiz=quizRepo.findById(quizNo).get();
        int score=0;
        List<Question> qns=quiz.getQuestions();
        int j=0;
        for(ResponseDao i:responses){
            if(i.getSelectedOption().equals(qns.get(j).getAnswer())){
                score++;
            }
            j++;
        }
        return score;
    }
}
