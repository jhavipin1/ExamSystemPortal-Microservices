package com.quiz.feignClient;

import com.category.entity.Quiz;
import com.quiz.entity.Question;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(value = "QUESTION-SERVICE", url = "http://localhost:8083")
@FeignClient(name = "QUESTION-MODULE")
public interface QuestionClient {

    @GetMapping("/question/quiz/{quizId}")
    public List<Question> getQuestionsOfQuiz(@PathVariable Long quizId);

}


