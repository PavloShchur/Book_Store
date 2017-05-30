package com.books.service;

import java.util.List;

import com.books.entity.Book;
import com.books.entity.Genre;

public interface BookService {
	
	Book save(Book book) throws Exception;
	List<Book> findAll();
	Book findOne(int id);
	void delete(int id);
	Book update(Book book);
	void addGenreToBook(Book book, Genre genre);

}
