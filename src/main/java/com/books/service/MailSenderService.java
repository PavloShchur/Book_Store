package com.books.service;

import com.books.entity.Book;

import java.util.Set;

public interface MailSenderService {

    void sendMail(String thema, String mailBody, String email);
    void sendMail_Check(String thema, Set<Book> mailBody, String email);
}
