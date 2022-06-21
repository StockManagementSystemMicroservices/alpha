package com.stock.management.system.service;

import com.stock.management.system.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto update(CategoryDto categoryDto);

    void delete(String name);

    CategoryDto getCategoryByName(String name);

    List<CategoryDto> getAll();

    Page<CategoryDto> getAll(Pageable pageable);
}
