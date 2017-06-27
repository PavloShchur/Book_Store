package com.books.controller;

import java.security.Principal;
import java.util.List;

import com.books.entity.Book;
import com.books.entity.User;
import com.books.service.BookService;
import com.books.service.UserService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.books.service.OrderService;

@Transactional
@Controller
public class OrdersController {

	@Autowired
	private OrderService ordersService;

	@Autowired
	private UserService userService;

	@Autowired
	private BookService bookService;

	@GetMapping("/addIntoBasket/{id}")
	public String addIntoBasket(Principal principal, @PathVariable int id){
		ordersService.makeSleep();
		ordersService.addIntoBasket(principal, id);
		return "redirect:/";
	}

	@GetMapping("/deleteFromBasket/{userId}/{bookId}")
	public String deleteFromBasket(@PathVariable int userId,
								   @PathVariable int bookId){

		ordersService.deleteFromBasket(userId, bookId);

		return "redirect:/profile";
	}

	@PostMapping("/buy")
	public String buy(Principal principal, @ModelAttribute("quantity") Integer quantity){
		User user = userService.findOne(Integer.parseInt(principal.getName()));
		System.out.println(user.getName());
		Hibernate.initialize(user.getBooks());

		for(Book book: user.getBooks()){
			System.out.println(book.getTitleOfBook());
			book.setQuantity(quantity);
			bookService.update(book);
		}
		ordersService.buy(Integer.parseInt(principal.getName()));

		return "redirect:/profile";

	}


	@PostMapping("/createNewOrder")
	public String createNewOrder(@RequestParam int userId, @RequestParam List<Integer> bookIds) {

		ordersService.save(userId, bookIds);

		return "redirect:/";
	}
}
