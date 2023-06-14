package com.example.Exam.repository;

import com.example.Exam.model.Question;

import java.util.Collection;
import java.util.Set;

public interface JavaQuestionRepository {
    Set<Question> questions();
    void init();
    Question add(Question question);
    Question remove(Question question);
    Collection<Question>getAll();
    public Set<Question> getQuestions();
}
