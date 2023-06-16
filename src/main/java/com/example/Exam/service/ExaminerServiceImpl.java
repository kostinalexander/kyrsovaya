package com.example.Exam.service;

import com.example.Exam.exception.ExaminerQuestionsException;
import com.example.Exam.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private QuestionService questionService;
    private QuestionService questionService1;

    @Autowired
    public ExaminerServiceImpl(@Qualifier("mathQuestionService") QuestionService questionService, @Qualifier("javaQuestionService") QuestionService questionService1) {
        this.questionService = questionService;
        this.questionService1 = questionService1;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() + questionService1.getAll().size()) {
            throw new ExaminerQuestionsException("Значение больше допустимого");
        }
        Set<Question> questionSet = new HashSet<>();
        for (int i = 0; i <= amount; i++) {
            if ((int) (Math.random() * 2) == 0) {
                questionSet.add(questionService.getRandomQuestion());
                break;
            } else {
                questionSet.add(questionService1.getRandomQuestion());
                break;
            }

        }
        return questionSet;
    }
}
