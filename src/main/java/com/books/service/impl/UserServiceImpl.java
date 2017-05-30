package com.books.service.impl;

import java.util.List;

import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userValidator")
    Validator validator;

    public void save(User user) throws Exception {
//        user.setName(user.getName().toUpperCase());
        validator.validate(user);
        userDao.save(user);

    }

    @SuppressWarnings("unchecked")
    public List findAll() {
        return userDao.findAll();

    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        userDao.delete(id);

    }

    public void update(User user) {
        userDao.save(user);
    }

}
