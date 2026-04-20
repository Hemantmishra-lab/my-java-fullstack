package com.booksphere.dao.impl;


import com.booksphere.dao.AuthorDao;
import com.booksphere.model.Author;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AuthorDaoImpl implements AuthorDao {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public List<Author> findAll(){
        return sessionFactory.getCurrentSession().createQuery("from Author", Author.class).list();
    }

    @Override
    public Author findById(Long Id){
        return sessionFactory.getCurrentSession().get(Author.class,Id);
    }
    @Override
    public void save(Author author){
        sessionFactory.getCurrentSession().merge(author);
    }
    @Override
    @Transactional
    public void delete(Long id){
        Author a = sessionFactory.getCurrentSession().get(Author.class,id);
        if(a!=null) sessionFactory.getCurrentSession().remove(a);

    }
    @Override
    public long count(){
        return sessionFactory.getCurrentSession().createQuery("SELECT COUNT(a) FROM Author a",Long.class).uniqueResult();
    }
}
