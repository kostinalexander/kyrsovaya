package com.example.Exam.service;

import com.example.Exam.model.Question;
import com.example.Exam.repository.JavaQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service
public class MathQuestionService implements QuestionService{

//    static List<Question> questionList = new ArrayList<>();
//
//    static {
//        questionList.add(new Question("2+2", "4"));
//        questionList.add(new Question("5*4 ", "20"));
//        questionList.add(new Question("10-1", "9"));
//        questionList.add(new Question("50/10", "5"));
//        questionList.add(new Question("2+11 ", " 13 "));
//    }

    private JavaQuestionRepository javaQuestionRepository;
    @Autowired
    public MathQuestionService(@Qualifier("mathQuestionsRepository") JavaQuestionRepository QuestionRepository){
        this.javaQuestionRepository = QuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question,answer);
        javaQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        javaQuestionRepository.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        javaQuestionRepository.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question>questionList1 = new ArrayList<>(javaQuestionRepository.getQuestions());
        Random random = new Random();
        int min = 0;
        int max = questionList1.size();
        return questionList1.get(random.nextInt(max-min));
    }
}
