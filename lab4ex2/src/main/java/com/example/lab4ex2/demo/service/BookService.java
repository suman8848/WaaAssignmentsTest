package com.example.lab4ex2.demo.service;

import com.example.lab4ex2.demo.dao.BookDao;
import com.example.lab4ex2.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public Collection getAllBookList(){
        return bookDao.getAll();
    }

    public void add(Book book) {
       bookDao.add(book);
    }

    public Book get(int id) {
        return get(id);
    }

    public void update(int id, Book book) {
        bookDao.update(id,book);
    }

    public void delete(int bookId) {
        bookDao.delete(bookId);
    }
}
