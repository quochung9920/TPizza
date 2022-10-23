package com.tpizza.repository;

import java.util.List;

import com.tpizza.pojos.Category;

public interface CategoryRepository {
    List<Category> getCategories(String name);
    Category getCategoryByShortName(String shortName);
    Category getCategoryById(int id);
}
