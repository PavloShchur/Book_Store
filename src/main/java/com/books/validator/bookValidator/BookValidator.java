package com.books.validator.bookValidator;

import com.books.dao.BookDao;
import com.books.entity.Author;
import com.books.entity.Book;
import com.books.validator.Validator;
import com.books.validator.authorValidator.AuthorException;
import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 30.05.2017.
 */
@Component
public class BookValidator implements Validator {

    @Autowired
    BookDao bookDao;

    @Override
    public void validate(Object o) throws Exception {
        Book book = (Book) o;

        if (book.getTitleOfBook().isEmpty()) {
            throw new BookException(BookValidationMessages.EMPTY_BOOKTITLE_FIELD);
        } else if (bookDao.findByTitleOfBook(book.getTitleOfBook()) != null) {
            throw new BookException(BookValidationMessages.BOOKTITLE_ALREADY_EXISTS);
        }
    }
}
