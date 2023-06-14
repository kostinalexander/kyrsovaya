package com.example.Exam;

import com.example.Exam.exception.ExaminerQuestionsException;
import com.example.Exam.model.Question;
import com.example.Exam.service.ExaminerServiceImpl;
import com.example.Exam.service.JavaQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equality;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ExaminerTest {
    private final JavaQuestionService javaQuestionService = mock(JavaQuestionService.class);
    private final JavaQuestionService javaQuestionService1 = mock(JavaQuestionService.class);
    private final ExaminerServiceImpl examinerService = new ExaminerServiceImpl(javaQuestionService,javaQuestionService1);

    static final List<Question> listQuestion = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        listQuestion.add(new Question("Кто вы", "люди"));
        listQuestion.add(new Question("кто я", "человек"));
    }



    @Test
    public void testGetQuestions() {
        when(javaQuestionService.getAll()).thenReturn(listQuestion);
        when(javaQuestionService.getRandomQuestion()).thenReturn(listQuestion.get(0));

        List<Question> questions = new ArrayList<>(examinerService.getQuestions(1));

        Assertions.assertEquals("Кто вы", questions.get(0).getQuestion());
        Assertions.assertEquals("люди", questions.get(0).getAnswer());
    }
    @Test
    public void testGetQuestionsNegative(){
        Assertions.assertThrows(ExaminerQuestionsException.class,()->examinerService.getQuestions(41));
    }


    @Test
    public void testRandomQuestion() {
        List<Question> questions = Arrays.asList(
                listQuestion.get(0),
                listQuestion.get(1)
        );
        when(javaQuestionService.add("Кто вы", "люди")).thenReturn(questions.get(0));
        Assertions.assertEquals(examinerService.getQuestions(0), examinerService.getQuestions(javaQuestionService.getAll().size()));
    }

}
