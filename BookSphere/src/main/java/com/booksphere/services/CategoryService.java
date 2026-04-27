package com.booksphere.services;

import com.booksphere.model.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category       findById(Long id);
    void           save(Category category);
    void           delete(Long id);
}