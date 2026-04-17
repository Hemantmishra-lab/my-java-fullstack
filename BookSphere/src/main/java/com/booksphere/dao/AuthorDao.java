package com.booksphere.dao;

import com.booksphere.model.Author;

import java.util.List;

public interface AuthorDao {

    List<Author> findAll();
    Author findById(Long id);
    void save(Author author);
    void delete(Long id);
    long count();

}
