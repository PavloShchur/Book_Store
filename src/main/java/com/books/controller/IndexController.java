package com.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.books.service.UserService;

@Controller
public class IndexController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "index";
	}
}
