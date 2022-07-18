package com.stock.management.system.service.impl;

import com.stock.management.system.dto.CategoryDto;
import com.stock.management.system.entity.Category;
import com.stock.management.system.repository.CategoryRepository;
import com.stock.management.system.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setName(categoryDto.getName());
        categoryRepository.save(category);

        return categoryDto;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(String name) {
        Category category = categoryRepository.findByName(name);
        categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        CategoryDto categoryDto = new CategoryDto();
        Category category =  categoryRepository.findByName(name);
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> getAll(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }
}
