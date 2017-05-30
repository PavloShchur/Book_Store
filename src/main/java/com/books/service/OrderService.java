package com.books.service;

import java.util.List;

import com.books.entity.Orders;

public interface OrderService {
	void save(int userId, List<Integer> drinksIds);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	Orders update(Orders orders);
}
