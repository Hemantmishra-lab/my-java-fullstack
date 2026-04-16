package com.trumio.Service;


import com.trumio.DAO.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.trumio.model.Book;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServices {

    @Autowired
    private BookDAO bookDAO;
    @Transactional
    public void registerBooks(Book book){
        //Business Logic here

        bookDAO.SaveBook(book);
    }
}
