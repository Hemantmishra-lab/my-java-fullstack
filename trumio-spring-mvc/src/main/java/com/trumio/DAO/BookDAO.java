package com.trumio.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.trumio.model.Book;

@Repository
public class BookDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void SaveBook(Book book){

        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.merge(book);
        currentSession.flush();
    }
}
