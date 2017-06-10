package com.books.service;

public interface MailSenderService {

    void sendMail(String thema, String mailBody, String email);
}
