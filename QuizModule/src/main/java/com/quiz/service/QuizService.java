package com.quiz.service;

import com.quiz.entity.Quiz;

import java.util.List;
import java.util.Set;

public interface QuizService {
    public Quiz addQuiz(Quiz quiz);

    public Quiz updateQuiz(Quiz quiz);

    public List<Quiz> getQuizzes();

    public Quiz getQuiz(Long quizId);

    public void deleteQuiz(Long quizId);


    public List<Quiz> getQuizzesOfCategory(Long categoryId);

    public List<Quiz> getActiveQuizzes();

    //public List<Quiz> getActiveQuizzesOfCategory(Category c);
}
