package com.books.service.impl;

import java.util.List;

import com.books.entity.Role;
import com.books.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.books.dao.UserDao;
import com.books.entity.User;
import com.books.service.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    @Qualifier("userValidator")
    Validator validator;

    @Autowired
    private BCryptPasswordEncoder encoder;

    

    public void save(User user) throws Exception {
//        user.setName(user.getName().toUpperCase());
        validator.validate(user);
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
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

    //UserDetailsService

    @Override
    public UserDetails loadUserByUsername(String value) throws UsernameNotFoundException {
        return userDao.findByNameOrEmail(value);
    }

}










