package com.stock.management.system.service.impl;

import com.stock.management.system.dto.CategoryDto;
import com.stock.management.system.repository.CategoryRepository;
import com.stock.management.system.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        return null;
    }

    @Override
    public void delete(String name) {

    }

    @Override
    public CategoryDto getCategoryByName(String name) {
        return null;
    }

    @Override
    public List<CategoryDto> getAll() {
        return null;
    }

    @Override
    public Page<CategoryDto> getAll(Pageable pageable) {
        return null;
    }
}
