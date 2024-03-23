package com.question.service;

import com.question.entity.Question;

import java.util.List;
import java.util.Set;

public interface QuestionService {

    public Question addQuestion(Question question);

    public Question updateQuestion(Question question);

    public List<Question> getQuestions();

    public Question getQuestion(Long questionId);

    public List<Question> getQuestionsOfQuiz(Long quizId);

    public void deleteQuestion(Long quesId);

}
