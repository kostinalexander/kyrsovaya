package com.example.Exam.repository;

import com.example.Exam.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
@Repository
public class MathQuestionsRepository implements JavaQuestionRepository{
    private Set<Question> questions = new HashSet<>();
    @Override
    public Set<Question> questions() {

        questions.add(new Question("2+2", "4"));
        questions.add(new Question("5*4 ", "20"));
        questions.add(new Question("10-1", "9"));
        questions.add(new Question("50/10", "5"));
        questions.add(new Question("2+11 ", " 13 "));
        return questions;
    }


    @PostConstruct
    @Override
    public void init() {
        questions();
    }
    @Override
    public Set<Question> getQuestions() {
        return questions;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}



