package com.books.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Book")
public class Book extends AbstractEntity {

	@Column(name = "Title")
	private String titleOfBook;
	@Column(name = "Price")
	private int priceOfBook;
	@Column(name = "Name")
	private String nameOfAuthor;
	@Column(name = "Surname")
	private String surnameOfAuthor;
	@Column(name = "Year")
	private short yearOfPublishing;

	@Lob
	@Column(name = "Image")
	private byte[] empImage;

	@ManyToOne
	private Genre genre;

	@ManyToMany
	@JoinTable(name = "UserBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "OrderBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "OrderID"))
	private List<Orders> orders;

	@ManyToMany
	@JoinTable(name = "AuthorBook", joinColumns = @JoinColumn(name = "BookID"), inverseJoinColumns = @JoinColumn(name = "AuthorID"))
	private List<Author> authors;

	public Book() {
	}

	public Book(String titleOfBook, int priceOfBook, String nameOfAuthor, String surnameOfAuthor,
			short yearOfPublishing, byte[] empImage, Genre genre) {
		super();
		this.titleOfBook = titleOfBook;
		this.priceOfBook = priceOfBook;
		this.nameOfAuthor = nameOfAuthor;
		this.surnameOfAuthor = surnameOfAuthor;
		this.yearOfPublishing = yearOfPublishing;
		this.empImage = empImage;
		this.genre = genre;
	}

	public int getPriceOfBook() {
		return priceOfBook;
	}

	public void setPriceOfBook(int priceOfBook) {
		this.priceOfBook = priceOfBook;
	}

	public String getNameOfAuthor() {
		return nameOfAuthor;
	}

	public void setNameOfAuthor(String nameOfAuthor) {
		this.nameOfAuthor = nameOfAuthor;
	}

	public String getSurnameOfAuthor() {
		return surnameOfAuthor;
	}

	public void setSurnameOfAuthor(String surnameOfAuthor) {
		this.surnameOfAuthor = surnameOfAuthor;
	}

	public byte[] getEmpImage() {
		return empImage;
	}

	public void setEmpImage(byte[] empImage) {
		this.empImage = empImage;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public String getTitleOfBook() {
		return titleOfBook;
	}

	public void setTitleOfBook(String titleOfBook) {
		this.titleOfBook = titleOfBook;
	}

	public short getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setYearOfPublishing(short yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}

	@Override
	public String toString() {
		return "Book [titleOfBook=" + titleOfBook + ", priceOfBook=" + priceOfBook + ", nameOfAuthor=" + nameOfAuthor
				+ ", surnameOfAuthor=" + surnameOfAuthor + ", yearOfPublishing=" + yearOfPublishing + ", genre=" + genre
				+ "]";
	}

}