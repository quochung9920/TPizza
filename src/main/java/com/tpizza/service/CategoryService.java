package com.tpizza.service;

import java.util.List;

import com.tpizza.pojos.Category;

public interface CategoryService {
    List<Category> getCategories(String name);
    Category getCategoryByShortName(String shortName);
    Category getCategoryById(int id);
}
