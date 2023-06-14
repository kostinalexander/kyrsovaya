package com.example.Exam;

import com.example.Exam.model.Question;
import com.example.Exam.repository.JavaQuestionRepository;
import com.example.Exam.repository.MathQuestionsRepository;
import com.example.Exam.service.MathQuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;

public class MathTest {
    static Set<Question> questions = new HashSet<>();

    @BeforeAll
    public static void setUp() {
        questions.add(new Question("5+1", "6"));
        questions.add(new Question("5-1", "4"));
    }
    private final MathQuestionsRepository mathQuestionsRepository = mock(MathQuestionsRepository.class);

    private final MathQuestionService mathQuestionService = new MathQuestionService(mathQuestionsRepository);

    @Test
    public void testRemoveQuestionsPositive(){
        Question question = mathQuestionService.remove(new Question("5+1", "6"));
        Assertions.assertEquals(question.getQuestion(),question.getQuestion());
        Assertions.assertEquals(question.getAnswer(),question.getAnswer());
    }
    @Test
    public void testGetAllQuestions(){

        questions.add(new Question("алвд","валд"));
        Function<Question, Object> questionObjectFunction = (Function<Question, Object>) element ->
              questions = mathQuestionService.getAll().stream().collect(Collectors.toSet());
        Assertions.assertEquals(questions.size(),3);
    }
    @Test
    public void testAddQuestionsPositive() {
        Question newQuestion = new Question("Кто вы такой", "человек");
        Question question = mathQuestionService.add(newQuestion);
        questions.add(newQuestion);
        Assertions.assertEquals(question.getQuestion(), question.getQuestion());
        Assertions.assertEquals(question.getAnswer(), question.getAnswer());
    }
}
