package com.stock.management.system.controller;

import com.stock.management.system.dto.CategoryDto;
import com.stock.management.system.entity.Category;
import com.stock.management.system.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@RestController
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/category")
    public ResponseEntity<CategoryDto> getCategory(String name) {
        if(name != null || !name.equals(" ")) {
            Category category = new Category();
            category.setId(UUID.randomUUID().toString());
            category.setName(name);
            return ResponseEntity.ok(categoryService.getCategoryByName(name));
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not Found");
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/category")
    public ResponseEntity<CategoryDto> save(@RequestBody CategoryDto categoryDto) {
        if(categoryDto != null) {
            CategoryDto existCategory = categoryService.getCategoryByName(categoryDto.getName());
            if(existCategory == null)
                return ResponseEntity.ok(categoryService.save(categoryDto));
            else
                throw new ResponseStatusException(HttpStatus.CONFLICT,"Exist category name");
        }
        throw new ResponseStatusException(HttpStatus.CONFLICT,"Exist category is empty");
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/category")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto) {
        if (categoryDto!= null) {
            CategoryDto existCategory = categoryService.getCategoryByName(categoryDto.getName());
            if(existCategory!= null) {
                return ResponseEntity.ok(categoryService.update(categoryDto));
            }
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not Found Category");
        }
        else {
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Request category mustn't empty");
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/category")
    public ResponseEntity<Boolean> delete(String name) {
        CategoryDto existCategory = categoryService.getCategoryByName(name);
        if(existCategory!= null){
            categoryService.delete(name);
            return ResponseEntity.ok(true);
        }
        else
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Not Found Category");
    }
}
