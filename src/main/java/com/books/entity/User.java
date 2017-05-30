package com.books.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends AbstractEntity{

	
	/* @Column(unique=true) */
	@Column(name = "Name")
	private String name;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password")
	private String password;
	@Column(name = "Role")
	private RoleOfMan roleOfMan;

	@OneToMany(mappedBy = "user")
	private List<Orders> orders;

	@ManyToMany
	@JoinTable(name = "UserBook", joinColumns = @JoinColumn(name = "UserID"), inverseJoinColumns = @JoinColumn(name = "BookID"))
	private List<Book> books;

	public User() {
	}

	public User(String name, String email, String password, RoleOfMan roleOfMan) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.roleOfMan = roleOfMan;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleOfMan getRoleOfMan() {
		return roleOfMan;
	}

	public void setRoleOfMan(RoleOfMan roleOfMan) {
		this.roleOfMan = roleOfMan;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + "]";
	}
	
	

}
