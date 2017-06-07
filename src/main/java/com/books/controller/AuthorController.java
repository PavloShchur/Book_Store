package com.books.controller;

import com.books.editors.CountryEditor;
import com.books.editors.GenreEditor;
import com.books.entity.Country;
import com.books.entity.Genre;
import com.books.entity.User;
import com.books.service.CountryService;
import com.books.validator.authorValidator.AuthorValidationMessages;
import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.books.entity.Author;
import com.books.service.AuthorService;

@Controller
public class AuthorController {
	@Autowired
	private AuthorService authorService;

	@Autowired
	private CountryService countryService;

	@InitBinder
	public void init(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor());
	}

	@GetMapping("/listOfAuthors")
	public String author(Model model) {
		model.addAttribute("authors", authorService.findAll());
		model.addAttribute("coutries", countryService.findAll());
		model.addAttribute("author", new Author());
		return "views-authors-listOfAuthors";
	}

	@PostMapping("/saveAuthor")
	public String author(@ModelAttribute Author author, Model model) {
		try {
			authorService.save(author);
		} catch (Exception e) {
			if (e.getMessage().equals(AuthorValidationMessages.AUTHORNAME_ALREADY_EXISTS) ||
					e.getMessage().equals(AuthorValidationMessages.EMPTY_AUTHORNAME_FIELD)){
				model.addAttribute("AuthorNameException", e.getMessage());
			}
			model.addAttribute("coutries", countryService.findAll());
			return "views-authors-listOfAuthors";
		}
		return "redirect:/listOfAuthors";
	}

	@RequestMapping(value = "/deleteAuthor/{id}", method = RequestMethod.GET)
	public String deleteUAuthor(@PathVariable int id) {

		authorService.delete(id);

		return "redirect:/listOfAuthors";
	}

	@RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.GET)
	public String getAuthor(@PathVariable int id, Model model) {
		model.addAttribute("authorAttribute", authorService.findOne(id));
		return "views-authors-updateAuthors";
	}

	@RequestMapping(value = "/updateAuthor/{id}", method = RequestMethod.POST)
	public String updateAuthor(@ModelAttribute("author") Author author, @PathVariable int id, Model model) {
		author.setId(id);
		authorService.update(author);
		model.addAttribute("authors", authorService.findAll());
		return "views-authors-listOfAuthors";
	}

}
