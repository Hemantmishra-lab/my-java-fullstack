package com.booksphere.dao.impl;

import com.booksphere.dao.CategoryDao;
import com.booksphere.model.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Category c ORDER BY c.name", Category.class).list();
    }

    @Override
    public Category findById(Long id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public void save(Category category) {
        sessionFactory.getCurrentSession().merge(category);
    }

    @Override
    public void delete(Long id) {
        Category c = sessionFactory.getCurrentSession().get(Category.class, id);
        if (c != null) sessionFactory.getCurrentSession().remove(c);
    }
}