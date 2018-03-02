package com.example.lab4ex2.demo.dao;

import com.example.lab4ex2.demo.NoSuchResourceException;
import com.example.lab4ex2.demo.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDao  {

	private static int idCount = 1;
	private Map<Integer, Book> books = new HashMap<>();

	public BookDao() {
		add(new Book("Java","1001","Orlando",4000));
		add(new Book("C#","1002","Suman",2000));
	}

	public List<Book> getAll() {
		return new ArrayList<Book>(books.values());
	}

	public void add(Book book) {
		book.setId(idCount);
		books.put(idCount, book);
		idCount++;
	}

	public Book get(int id) {
		Book result = books.get(id);

		if (result == null) {
			throw new NoSuchResourceException("Book", id);
		}

		return result;
	}

	public void update(int bookId, Book book) {
		System.out.println(book);
		books.put(bookId, book);
	}


	public void delete(int bookId) {
		Book removed = books.remove(bookId);
		if (removed == null) {
			throw new NoSuchResourceException("Book", bookId);
		}
	}
}
