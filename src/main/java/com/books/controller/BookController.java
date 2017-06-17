package com.books.controller;

import com.books.editors.GenreEditor;
import com.books.entity.Genre;
import com.books.service.GenreService;
import com.books.validator.bookValidator.BookValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import com.books.entity.Book;
import com.books.service.BookService;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;


    @InitBinder
    public void init(WebDataBinder binder) {
        binder.registerCustomEditor(Genre.class, new GenreEditor());
    }


    @GetMapping("/listOfBooks")
    public String listOfBooks(Model model, @PageableDefault Pageable pageable) {
        System.out.println("list of books");
        model.addAttribute("books", bookService.findAllPages(pageable));
        model.addAttribute("genres", genreService.findAll());
        model.addAttribute("book", new Book());
        return "views-books-listOfBooks";
    }

    @PostMapping("/saveBook")
    public String listOfBooks(@ModelAttribute Book book, Model model,
                              @RequestAttribute("image") MultipartFile image,
                              @PageableDefault Pageable pageable) {
        try {
            bookService.save(book, image);
        } catch (Exception e) {
            if (e.getMessage().equals(BookValidationMessages.BOOKTITLE_ALREADY_EXISTS) ||
                    e.getMessage().equals(BookValidationMessages.EMPTY_BOOKTITLE_FIELD)) {
                model.addAttribute("BookNameException", e.getMessage());
            } else if (e.getMessage().equals(BookValidationMessages.PRICE_FIELD_IS_EMPTY)) {
                model.addAttribute("BookPriceException", e.getMessage());
            }
            model.addAttribute("books", bookService.findAllPages(pageable));
            model.addAttribute("genres", genreService.findAll());
            return "views-books-listOfBooks";
        }
        return "redirect:/listOfBooks";
    }

    @RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable int id) {

        bookService.delete(id);

        return "redirect:/listOfBooks";
    }

    @GetMapping("/updateBook/{id}")
    public String getBook(@PathVariable int id, Model model) {
        model.addAttribute("bookAttribute", bookService.findOne(id));
        return "views-books-updateBook";
    }

    @PostMapping("/updateBook/{id}")
    public String updateBook(@ModelAttribute Book book,
                             @RequestAttribute("image") MultipartFile image,
                             @PathVariable int id, Model model, @PageableDefault Pageable pageable) {
        book.setId(id);

        bookService.update(book, image);
        model.addAttribute("bookAttribute", bookService.findOne(id));
        bookService.findAllPages(pageable);
        return "redirect:/listOfBooks";
    }
}
