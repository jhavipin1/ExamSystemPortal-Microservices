package com.category.feignClient;


import com.category.entity.Quiz;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(value = "QUIZ-SERVICE", url = "http://localhost:8082")
@FeignClient(name = "QUIZ-MODULE")
public interface QuizClient {

    @GetMapping("/quiz/category/{categoryId}")
    public List<Quiz> getQuizzesOfCategory(@PathVariable Long categoryId);

  }


