package com.example.lab5ex2.lab5ex2.service;

import com.example.lab5ex2.lab5ex2.dao.BookDao;
import com.example.lab5ex2.lab5ex2.entity.Book;
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
        return bookDao.get(id);
    }

    public void update(int id, Book book) {
        bookDao.update(id,book);
    }

    public void delete(int bookId) {
        bookDao.delete(bookId);
    }
}
