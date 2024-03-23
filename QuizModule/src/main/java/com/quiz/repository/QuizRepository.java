package com.quiz.repository;

import com.quiz.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    public List<Quiz> findByCategoryId(Long categoryId);

    public List<Quiz> findByActive(Boolean b);

    //public List<Quiz> findByCategoryAndActive(Category c, Boolean b);

}
