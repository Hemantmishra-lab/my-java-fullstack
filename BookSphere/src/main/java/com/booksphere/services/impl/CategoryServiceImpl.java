package com.booksphere.service.impl;

import com.booksphere.dao.CategoryDao;
import com.booksphere.model.Category;
import com.booksphere.services.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private static final Logger LOG = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired private CategoryDao categoryDao;

    @Override @Transactional(readOnly = true)
    public List<Category> findAll() { LOG.info("BookSphere :: getCategories()"); return categoryDao.findAll(); }

    @Override @Transactional(readOnly = true)
    public Category findById(Long id) { return categoryDao.findById(id); }

    @Override
    public void save(Category category) { LOG.info("BookSphere :: saveCategory({})", category.getName()); categoryDao.save(category); }

    @Override
    public void delete(Long id) { LOG.info("BookSphere :: deleteCategory({})", id); categoryDao.delete(id); }
}