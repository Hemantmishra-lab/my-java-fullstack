package com.booksphere.dao;

import com.booksphere.model.Category;
import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    Category       findById(Long id);
    void           save(Category category);
    void           delete(Long id);
}