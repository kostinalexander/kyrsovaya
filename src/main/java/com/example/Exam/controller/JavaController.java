package com.example.Exam.controller;

import com.example.Exam.model.Question;
import com.example.Exam.service.JavaQuestionService;
import com.example.Exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController

public class JavaController {

    private QuestionService questionService;

    public JavaController(@Qualifier("javaQuestionService") QuestionService questionService){
        this.questionService = questionService;
    }
    @GetMapping("/exam/java/add")
     public Question add(@RequestParam String question, String answer){
     return questionService.add(question,answer);
    }
    @GetMapping("/exam/java/remove")
    public Question remove(@RequestParam String question, String answer){
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }
    @GetMapping("/exam/java")
    public Collection<Question>getAll(){
        return questionService.getAll();
    }
    @GetMapping("exam/java/random")
    public Question getRandomQuestion(){
        return questionService.getRandomQuestion();
    }
}
