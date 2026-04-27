package com.booksphere.services;

import com.booksphere.model.Book;
import java.util.List;

public interface BookService {
    List<Book> findAll(String keyword, int page, int pageSize);
    long       count(String keyword);
    long       countAll();
    Book       findById(Long id);
    void       save(Book book);
    void       delete(Long id);
}