package com.books.controller;

import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.books.entity.User;
import com.books.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/signUp")
	public String signp(Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("user", new User());
		return "views-user-signUp";
	}

	@PostMapping("/signUp")
	public String signupAfter(@ModelAttribute User user, Model model) throws Exception {
		try {
			userService.save(user);
		} catch (Exception e) {
			if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
					e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXISTS)) {
				model.addAttribute("UserNameException", e.getMessage());
			}
			return "views-user-signUp";}
		return "redirect:/signUp";
	}

	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable int id) {
		userService.delete(id);
		return "redirect:/signUp";
	}

	@GetMapping("/updateUser/{id}")
	public String getUser(@PathVariable int id, Model model) {
		model.addAttribute("userAttribute", userService.findOne(id));
		return "views-user-updateUser";
	}

	@PostMapping("/updateUser/{id}")
	public String updateUser(@ModelAttribute("user") User user, @PathVariable int id, Model model) {
		user.setId(id);
		userService.update(user);
		model.addAttribute("users", userService.findAll());
		return "views-user-signUp";
	}



}