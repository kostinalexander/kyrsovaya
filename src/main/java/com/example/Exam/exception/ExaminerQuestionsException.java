package com.example.Exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExaminerQuestionsException extends RuntimeException{
    public ExaminerQuestionsException() {
    }

    public ExaminerQuestionsException(String message) {
        super(message);
    }

    public ExaminerQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExaminerQuestionsException(Throwable cause) {
        super(cause);
    }

    public ExaminerQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
