package com.booksphere.service.impl;

import com.booksphere.dao.BookDao;
import com.booksphere.model.Book;
import com.booksphere.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    private static final Logger LOG = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired private BookDao bookDao;

    @Override @Transactional(readOnly = true)
    public List<Book> findAll(String keyword, int page, int pageSize) {
        LOG.info("BookSphere :: getBooks(keyword='{}', page={})", keyword, page);
        return bookDao.findAll(keyword, page, pageSize);
    }

    @Override @Transactional(readOnly = true) public long count(String keyword) { return bookDao.count(keyword); }
    @Override @Transactional(readOnly = true) public long countAll()            { return bookDao.countAll(); }
    @Override @Transactional(readOnly = true) public Book findById(Long id)     { return bookDao.findById(id); }

    @Override
    public void save(Book book) { LOG.info("BookSphere :: saveBook({})", book.getTitle()); bookDao.save(book); }

    @Override
    public void delete(Long id) { LOG.info("BookSphere :: deleteBook({})", id); bookDao.delete(id); }
}