package com.category.service;


import com.category.entity.Category;
import com.category.feignClient.QuizClient;
import com.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {



    @Autowired
    public CategoryRepository categoryRepository;

    @Autowired
    public QuizClient quizClient;

    public CategoryServiceImpl(CategoryRepository categoryRepository, QuizClient quizClient) {
        this.categoryRepository = categoryRepository;
        this.quizClient = quizClient;
    }
    @Override
    public Category addCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepository.save(category);
    }

    @Override
    public List<Category> getCategories() {

        List<Category> categories =categoryRepository.findAll();
        List<Category> newCategoryList =categories.stream().map(category -> {
            category.setQuizList(quizClient.getQuizzesOfCategory(category.getCategoryId()));
            return category;
        }).collect(Collectors.toList());

        return newCategoryList;
    }

    @Override
    public Category getCategory(Long categoryId) {

        Category category= categoryRepository.findById(categoryId).get();
        category.setQuizList(quizClient.getQuizzesOfCategory(category.getCategoryId()));
        return category;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = new Category();
       // category.setCid(categoryId);

        this.categoryRepository.delete(category);
    }
}
