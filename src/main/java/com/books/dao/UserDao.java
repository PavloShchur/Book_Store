package com.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.books.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

//	void addOrderToUser(User user, Orders orders);
	User findByNameAndEmail(String name, String email);
	
	@Query("select u from User u left join fetch u.books where u.id=:id")
	User findUserWithBooks(@Param("id")int id);
	
	User findByName(String name);

}
