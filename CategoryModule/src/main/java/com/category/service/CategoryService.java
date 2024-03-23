package com.category.service;

import com.category.entity.Category;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;


public interface CategoryService {
    public Category addCategory(Category category);
    public Category updateCategory(Category category);
    public List<Category> getCategories();
    public Category getCategory(Long categoryId);
    public void deleteCategory(Long categoryId);

}
