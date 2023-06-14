package com.example.Exam;

import com.example.Exam.model.Question;
import com.example.Exam.repository.JavaQuestionRepository;
import com.example.Exam.service.JavaQuestionService;
import com.example.Exam.service.QuestionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mockito.Mockito.mock;

public class JavaQuestionsTests {
    static List<Question> questionList = new ArrayList<>();

    @BeforeAll
    public static void setUp() {
        questionList.add(new Question("Как вас зовут", "Александр"));
        questionList.add(new Question("Сколько вам лет", "22"));
    }

    private final JavaQuestionRepository javaQuestionRepository = mock(JavaQuestionRepository.class);
    private final JavaQuestionService javaQuestionService = new JavaQuestionService(javaQuestionRepository);

    @Test
    public void testRemoveQuestionsPositive(){
        Question question = javaQuestionService.remove(new Question("Сколько вам лет", "22"));
    Assertions.assertEquals(questionList.get(1),question);
    }
    @Test
    public void testGetAllQuestions(){

        questionList.add(new Question("алвд","валд"));
        Function<Question, Object> questionObjectFunction = (Function<Question, Object>) element ->
        questionList = javaQuestionService.getAll().stream().collect(Collectors.toList());
        Assertions.assertEquals(questionList.size(),3);
    }

    @Test
    public void testAddQuestionsPositive() {
        Question newQuestion = new Question("Кто вы такой", "человек");
        Question question = javaQuestionService.add(newQuestion);
        questionList.add(newQuestion);
        Assertions.assertEquals(questionList.get(2), question);
    }
}
