package com.books.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders extends AbstractEntity {

	private LocalDate localDate;

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "OrderBook", joinColumns = @JoinColumn(name = "OrderID"), inverseJoinColumns = @JoinColumn(name = "BookID"))
	private List<Book> books;

	public Orders() {
	}

	public Orders(LocalDate localDate) {
		super();
		this.localDate = localDate;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(Iterable<Book> hashSet) {
		this.books = (List<Book>) hashSet;
	}

	@Override
	public String toString() {
		return "Orders [localDate=" + localDate + "]";
	}

}
