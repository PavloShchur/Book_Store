package com.books.controller;

import com.books.editors.GenreEditor;
import com.books.entity.Author;
import com.books.entity.Country;
import com.books.entity.Genre;
import com.books.service.CountryService;
import com.books.service.GenreService;
import com.books.validator.bookValidator.BookValidationMessages;
import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.books.entity.Book;
import com.books.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private GenreService genreService;


	@InitBinder
	public void init(WebDataBinder binder){
		binder.registerCustomEditor(Genre.class, new GenreEditor());
	}


	@GetMapping("/listOfBooks")
	public String listOfBooks(Model model) {
		model.addAttribute("books", bookService.findAll());
		model.addAttribute("genres", genreService.findAll());
		model.addAttribute("book", new Book());
		return "listOfBooks";
	}

	@PostMapping("saveBook")
	public String listOgBooks(@ModelAttribute Book book, Model model) {
		try {
			bookService.save(book);
		} catch (Exception e) {
			if (e.getMessage().equals(BookValidationMessages.BOOKTITLE_ALREADY_EXISTS) ||
					e.getMessage().equals(BookValidationMessages.EMPTY_BOOKTITLE_FIELD)){
				model.addAttribute("BookNameException", e.getMessage());
			}
			return "listOfBooks";
		}
		return  "redirect:/listOfBooks";
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable int id) {

		bookService.delete(id);

		return "redirect:/listOfBooks";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.GET)
	public String getBook(@PathVariable int id, Model model) {
		model.addAttribute("bookAttribute", bookService.findOne(id));
		return "updateBook";
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book, @PathVariable int id, Model model) {
		book.setId(id);
		bookService.update(book);
		model.addAttribute("books", bookService.findAll());
		return "listOfBooks";
	}

}
