package com.booksphere.dao.impl;

import com.booksphere.dao.BookDao;
import com.booksphere.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired private SessionFactory sessionFactory;

    private Session session() { return sessionFactory.getCurrentSession(); }

    @Override
    public List<Book> findAll(String keyword, int page, int pageSize) {
        // JOIN FETCH author so author name is available without a separate query
        // (avoids LazyInitializationException when accessing b.author.name in templates)
        String hql = keyword.isBlank()
                ? "SELECT b FROM Book b LEFT JOIN FETCH b.author ORDER BY b.title"
                : "SELECT b FROM Book b LEFT JOIN FETCH b.author WHERE lower(b.title) LIKE :kw OR lower(b.isbn) LIKE :kw ORDER BY b.title";

        var query = session().createQuery(hql, Book.class);
        if (!keyword.isBlank()) query.setParameter("kw", "%" + keyword.toLowerCase() + "%");
        return query.setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .list();
    }

    @Override
    public long count(String keyword) {
        String hql = keyword.isBlank()
                ? "SELECT COUNT(b) FROM Book b"
                : "SELECT COUNT(b) FROM Book b WHERE lower(b.title) LIKE :kw OR lower(b.isbn) LIKE :kw";
        var query = session().createQuery(hql, Long.class);
        if (!keyword.isBlank()) query.setParameter("kw", "%" + keyword.toLowerCase() + "%");
        return query.uniqueResult();
    }

    @Override
    public long countAll() {
        return session().createQuery("SELECT COUNT(b) FROM Book b", Long.class).uniqueResult();
    }

    @Override
    public Book findById(Long id) {
        return session().get(Book.class, id);
    }

    @Override
    public void save(Book book) {
        session().merge(book);
    }

    @Override
    public void delete(Long id) {
        Book b = session().get(Book.class, id);
        if (b != null) session().remove(b);
    }
}