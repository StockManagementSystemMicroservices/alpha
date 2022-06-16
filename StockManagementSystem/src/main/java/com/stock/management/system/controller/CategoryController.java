package com.stock.management.system.controller;

import com.sms.api.CategoriesApi;
import com.sms.api.CategoryNameApi;
import com.sms.models.Category;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController implements CategoriesApi, CategoryNameApi {

    @Override
    public ResponseEntity<Void> createCategory(Category body) {
        return null;
    }

    @Override
    public ResponseEntity<List<Category>> listCategories() {
        ArrayList<Category> categories = new ArrayList<>();
        Category category = new Category();
        categories.add(category);

        return new ResponseEntity<>(categories, HttpStatus.OK);
    }


    // Category Name
    @Override
    public ResponseEntity<Void> deleteCategory(String categoryName) {
        return null;
    }

    @Override
    public ResponseEntity<Category> getCategoryByCategoryName(String categoryName) {
        return new ResponseEntity<>(new Category(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> updateCategory(String categoryName, Category body) {
        return null;
    }
}
