package com.books.controller;

import java.security.Principal;
import java.util.List;

import com.books.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.books.service.OrderService;

@Controller
public class OrdersController {

	@Autowired
	private OrderService ordersService;

	@Autowired
	private UserService userService;

	@GetMapping("/addIntoBasket/{id}")
	public String buy(Principal principal, @PathVariable int id){

		ordersService.addIntoBasket(principal, id);

		return "redirect:/";
	}

	@GetMapping("/deleteFromBasket/{userId}/{bookId}")
	public String deleteFromBasket(@PathVariable int userId,
								   @PathVariable int drinkId){

		ordersService.deleteFromBasket(userId, drinkId);

		return "redirect:/profile";
	}

	@PostMapping("/buy")
	public String buy(Principal principal){

		ordersService.buy(Integer.parseInt(principal.getName()));

		return "redirect:/profile";

	}


	@PostMapping("/createNewOrder")
	public String createNewOrder(@RequestParam int userId, @RequestParam List<Integer> bookIds) {

		ordersService.save(userId, bookIds);

		return "redirect:/";
	}
}
