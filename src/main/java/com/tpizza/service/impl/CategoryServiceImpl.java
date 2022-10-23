package com.tpizza.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tpizza.pojos.Category;
import com.tpizza.repository.CategoryRepository;
import com.tpizza.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories(String name) {
        return this.categoryRepository.getCategories(name);
    }

    @Override
    public Category getCategoryById(int id) {
        return this.categoryRepository.getCategoryById(id);
    }

    @Override
    public Category getCategoryByShortName(String shortName) {
        return this.categoryRepository.getCategoryByShortName(shortName);
    }
    
}
