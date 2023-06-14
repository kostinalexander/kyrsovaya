package com.example.Exam.service;

import com.example.Exam.model.Question;
import com.example.Exam.repository.JavaQuestionRepository;
import com.example.Exam.repository.JavaQuestionsRepostitoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class JavaQuestionService implements QuestionService{
// static List<Question> questionList = new ArrayList<>();
//
//    static {
//        questionList.add(new Question("Какой язык программирования вы изучаете", "Java"));
//        questionList.add(new Question("Какая переменная в Java самая большая ", "Long"));
//        questionList.add(new Question("Как называется строка в Java", "String"));
//        questionList.add(new Question("Как называют динамическйи массив", "ArrayList"));
//        questionList.add(new Question("Существует цикл for и ... ", " while "));
//    }
    private JavaQuestionRepository javaQuestionRepository;
    @Autowired
   public JavaQuestionService(@Qualifier("javaQuestionsRepostitoryImpl") JavaQuestionRepository QuestionRepository){
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
        List<Question>questionList = new ArrayList<>(javaQuestionRepository.getQuestions());
        Random random = new Random();
        int min = 0;
        int max = questionList.size();
        return questionList.get(random.nextInt(max-min));
    }
}
