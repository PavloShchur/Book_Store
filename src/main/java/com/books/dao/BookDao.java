package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Book;

public interface BookDao extends JpaRepository<Book, Integer> {

    Book findByTitleOfBook(String name);
    Book findByPriceOfBook(int price);

	// public byte[] addImageToBook(String path) throws IOException;
}
