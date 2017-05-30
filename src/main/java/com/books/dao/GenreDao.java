package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.books.entity.Genre;


public interface GenreDao extends JpaRepository<Genre, Integer> {
    Genre findByGenreOfBook(String name);
}
