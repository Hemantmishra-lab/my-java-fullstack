package com.booksphere.services;

import com.booksphere.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> findAll();
    Author findById(Long id);
    void save(Author author);
    void delete(Long id);
    long count();
}
