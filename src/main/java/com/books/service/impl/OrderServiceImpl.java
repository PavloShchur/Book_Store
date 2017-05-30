package com.books.service.impl;

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

	public void save(int userId, List<Integer> drinksIds) {
		Orders orders = new Orders(LocalDate.now());
		orderDao.saveAndFlush(orders);

		List<Book> drinks = new ArrayList<Book>();

		for (Integer id : drinksIds) {
			drinks.add(bookDao.findOne(id));
		}

		orders.setBooks(new HashSet<Book>(drinks));

		User user = userDao.findOne(userId);

		orders.setUser(user);

		orderDao.save(orders);
	}
}
