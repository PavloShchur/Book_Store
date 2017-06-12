package com.books.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.books.dao.BookDao;
import com.books.dao.GenreDao;
import com.books.entity.Book;
import com.books.entity.Genre;
import com.books.service.BookService;
import org.springframework.web.multipart.MultipartFile;

@SuppressWarnings("rawtypes")
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Autowired
    private GenreDao genreDao;

    @Autowired
    @Qualifier("bookValidator")
    Validator validator;

    public Book save(Book book, MultipartFile image) throws Exception {
        validator.validate(book);
        String path = System.getProperty("catalina.home") + "/resources/"
                + book.getTitleOfBook() + "/" + image.getOriginalFilename();

        book.setPathImage("resources/" + book.getTitleOfBook() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error with file");
        }
        return bookDao.save(book);
    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return bookDao.findAll();
    }

    public Book findOne(int id) {
        return bookDao.findOne(id);
    }

    public void delete(int id) {
        bookDao.delete(id);
    }

    public Book update(Book book) {


        return bookDao.save(book);
    }

    public void addGenreToBook(Book book, Genre genre) {
        book.setGenre(genre);
        bookDao.save(book);
    }

}
