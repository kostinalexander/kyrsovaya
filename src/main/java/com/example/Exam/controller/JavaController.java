package com.example.Exam.controller;

import com.example.Exam.model.Question;
import com.example.Exam.service.JavaQuestionService;
import com.example.Exam.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class JavaController {

    private QuestionService questionService;

    public JavaController(@Qualifier("javaQuestionService") QuestionService questionService){
        this.questionService = questionService;
    }
    @GetMapping("/java/add")
     public Question add(@RequestParam String question, String answer){
     return questionService.add(question,answer);
    }
    @GetMapping("/java/remove")
    public Question remove(@RequestParam String question, String answer){
        Question question1 = new Question(question, answer);
        return questionService.remove(question1);
    }
    @GetMapping("/java")
    public Collection<Question>getAll(){
        return questionService.getAll();
    }
    @GetMapping("/java/random")
    public Question getRandomQuestion(){
        return questionService.getRandomQuestion();
    }
}
