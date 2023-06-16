package com.example.Exam.controller;

import com.example.Exam.model.Question;
import com.example.Exam.service.ExaminerService;
import com.example.Exam.service.QuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ExamController {

    private ExaminerService examinerService;
    public ExamController(ExaminerService examinerService){
        this.examinerService = examinerService;
    }
    @GetMapping("/examiner")
    public Collection<Question>getQuestions(@PathVariable int amount){
        return examinerService.getQuestions(amount);
    }
}
