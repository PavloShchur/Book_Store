package com.books.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.dao.BookDao;
import com.books.dao.OrderDao;
import com.books.dao.UserDao;
import com.books.entity.Book;
import com.books.entity.Orders;
import com.books.entity.User;
import com.books.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private BookDao bookDao;

	@Autowired
	private UserDao userDao;

	public Orders save(Orders orders) {
		return orderDao.save(orders);
	}

	public List<Orders> findAll() {
		return orderDao.findAll();
	}

	public Orders findOne(int id) {
		return orderDao.findOne(id);
	}

	public void delete(int id) {
		orderDao.delete(id);
	}

	public Orders update(Orders orders) {
		return orderDao.save(orders);
	}

	@Override
	public void addIntoBasket(Principal principal, int id) {
		User user = userDao.findUserWithBooks(Integer.parseInt(principal.getName()));
		Book book = bookDao.findOne(id);
		user.getBooks().add(book);
		userDao.save(user);
	}

	@Override
	public void deleteFromBasket(int userId, int bookId) {

	}

	@Override
	public void buy(int userId) {

	}

	public void save(int userId, List<Integer> booksIds) {
		Orders orders = new Orders(LocalDate.now());
		orderDao.saveAndFlush(orders);

		List<Book> books = new ArrayList<Book>();

		for (Integer id : booksIds) {
			books.add(bookDao.findOne(id));
		}

		orders.setBooks(new HashSet<Book>(books));

		User user = userDao.findOne(userId);

		orders.setUser(user);

		orderDao.save(orders);
	}
}
