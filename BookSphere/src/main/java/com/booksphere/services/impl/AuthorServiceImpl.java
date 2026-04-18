package com.booksphere.services.impl;

import com.booksphere.dao.AuthorDao;
import com.booksphere.model.Author;
import com.booksphere.services.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService{
    private static final Logger Log = LoggerFactory.getLogger(AuthorServiceImpl.class);
    @Autowired
    private AuthorDao authorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Author> findAll(){
        Log.info("BookSphere :: getAuthors()");
        return authorDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Author findById(Long id){
        return authorDao.findById(id);
    }

    @Override
    @Transactional
    public void save(Author author){
        Log.info("BookSphere :: saveAuthor({})",author.getName());
        authorDao.save(author);
    }

    @Override
    public void delete(Long id){
        Log.info("BookSphere :: deleteAuthor({})",id);
        authorDao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count(){
        return authorDao.count();
    }
}
