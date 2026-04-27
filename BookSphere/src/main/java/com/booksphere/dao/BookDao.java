package com.booksphere.dao;

import com.booksphere.model.Book;
import java.util.List;

public interface BookDao {

    List<com.booksphere.model.Book> findAll(String keyword, int page, int pageSize);
    long count(String keyword);
    com.booksphere.model.Book findById(Long id);
    void save(Book book);
    void delete(Long id);
    long countAll();


}
