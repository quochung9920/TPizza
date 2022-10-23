package com.tpizza.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tpizza.pojos.Category;
import com.tpizza.service.CategoryService;

@RestController
@RequestMapping("/api")
public class ApiCategoryController {

    @Autowired
    private CategoryService categoryService;
    
    @GetMapping(path = "/categories", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Category>> getCategories() {
        try {
            List<Category> categories = this.categoryService.getCategories("");
            return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
