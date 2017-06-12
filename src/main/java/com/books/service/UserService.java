package com.books.service;

import java.security.Principal;
import java.util.Set;

import com.books.entity.User;

public interface UserService {
    void save(User user) throws Exception;

    Set<User> findAll();

    User findOne(int id);

    void delete(int id);

    void update(User user);

    User findUserWithOrders(int id);

    User findUserWithBooks(int id);

    User findByUuid(String uuid);

    void like(Principal principal, int id);


}
