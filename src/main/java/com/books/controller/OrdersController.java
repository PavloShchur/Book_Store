package com.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.service.OrderService;

@Controller
public class OrdersController {

	@Autowired
	private OrderService ordersService;

	@PostMapping("/createNewOrder")
	public String createNewOrder(@RequestParam int userId, @RequestParam List<Integer> bookIds) {

		ordersService.save(userId, bookIds);

		return "redirect:/";
	}
}
