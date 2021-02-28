/**
 * 
 */
package com.demo.survey.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.survey.model.User;

/**
 * @author hp
 *
 */
public interface UserRepository extends MongoRepository<User, String> {
	
	  User findByEmail(String email);
	  User findByUserId(long userId);
	 

}
