/**
 * 
 */
package com.demo.survey.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.survey.exception.HelpNowException;
import com.demo.survey.model.User;
import com.demo.survey.repository.UserRepository;

/**
 * @author hp
 *
 */

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	/**
	 * 
	 * @param users
	 * @return list of users
	 * @throws Exception
	 */
	public User createUser(User user) throws HelpNowException {

		if (user != null) {

			// Check if user already exists in the system with same email address.
			User existinguser = userRepo.findByEmail(user.getEmail());
			if (existinguser != null) {

				throw new HelpNowException("Email address already exists");
			} else {
				user = userRepo.save(user);
			}

		}
		return user;

	}

	/**
	 * 
	 * @return list of all users
	 */
	public List<User> findAllUser() {

		List<User> userList = userRepo.findAll();

		return userList;

	}

}
