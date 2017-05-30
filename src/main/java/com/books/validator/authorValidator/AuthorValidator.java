package com.books.validator.authorValidator;

import com.books.dao.AuthorDao;
import com.books.dao.UserDao;
import com.books.entity.Author;
import com.books.entity.User;
import com.books.validator.Validator;
import com.books.validator.userValidator.UserException;
import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by User on 30.05.2017.
 */

@Component
public class AuthorValidator implements Validator {
    @Autowired
    AuthorDao authorDao;

    @Override
    public void validate(Object o) throws Exception {
        Author author = (Author) o;

        if (author.getName().isEmpty()) {
            throw new AuthorException(AuthorValidationMessages.EMPTY_AUTHORNAME_FIELD);
        } else if (authorDao.findByName(author.getName()) != null) {
            throw new AuthorException(AuthorValidationMessages.AUTHORNAME_ALREADY_EXISTS);
        }

    }
}
