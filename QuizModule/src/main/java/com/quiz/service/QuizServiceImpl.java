package com.quiz.service;

import com.category.entity.Category;
import com.quiz.entity.Quiz;
import com.quiz.feignClient.QuestionClient;
import com.quiz.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionClient) {
        this.quizRepository = quizRepository;
        this.questionClient = questionClient;
    }

    @Autowired
    public QuizRepository quizRepository;

    @Autowired
    public QuestionClient questionClient;



    @Override
    public Quiz addQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return this.quizRepository.save(quiz);
    }

    @Override
    public List<Quiz> getQuizzes() {

        List<Quiz> quizList=quizRepository.findAll();
        List<Quiz> newQuizList=quizList.stream().map(quiz -> {
            quiz.setQuestionList(questionClient.getQuestionsOfQuiz(quiz.getQuizId()));
            return quiz;
        }).collect(Collectors.toList());
        return  newQuizList;



    }

    @Override
    public Quiz getQuiz(Long quizId) {
        return this.quizRepository.findById(quizId).get();
    }

    @Override
    public void deleteQuiz(Long quizId) {
        this.quizRepository.deleteById(quizId);
    }

   @Override
    public List<Quiz> getQuizzesOfCategory(Long category) {

        return this.quizRepository.findByCategoryId(category);
    }


    //get active quizzes

    @Override
    public List<Quiz> getActiveQuizzes() {
        return this.quizRepository.findByActive(true);
    }
/*
    @Override
    public List<Quiz> getActiveQuizzesOfCategory(Category c) {
        return this.quizRepository.findByCategoryAndActive(c, true);
    }*/

}
