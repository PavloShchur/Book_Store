package com.books.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Genre")
public class Genre extends AbstractEntity {

	@Column(name = "Genre")
	private String genreOfBook;

	@OneToMany(mappedBy = "genre")
	private List<Book> books;

	public Genre() {
	}

	public Genre(String genreOfBook) {
		super();
		this.genreOfBook = genreOfBook;
	}

	public String getGenreOfBook() {
		return genreOfBook;
	}

	public void setGenreOfBook(String genreOfBook) {
		this.genreOfBook = genreOfBook;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Genre [genreOfBook=" + genreOfBook + "]";
	}

}
