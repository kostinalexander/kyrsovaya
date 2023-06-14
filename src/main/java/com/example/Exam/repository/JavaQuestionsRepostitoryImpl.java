package com.example.Exam.repository;

import com.example.Exam.model.Question;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
@Repository
public class JavaQuestionsRepostitoryImpl implements JavaQuestionRepository{
 private Set<Question> questions = new HashSet<>();
    @Override
    public Set<Question> questions() {

            questions.add(new Question("Какой язык программирования вы изучаете", "Java"));
            questions.add(new Question("Какая переменная в Java самая большая ", "Long"));
            questions.add(new Question("Как называется строка в Java", "String"));
            questions.add(new Question("Как называют динамическйи массив", "ArrayList"));
            questions.add(new Question("Существует цикл for и ... ", " while "));
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
