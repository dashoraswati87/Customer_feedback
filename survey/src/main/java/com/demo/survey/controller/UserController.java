/**
 * 
 */
package com.demo.survey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.survey.exception.HelpNowException;
import com.demo.survey.model.User;
import com.demo.survey.service.UserService;

/**
 * @author hp
 *
 */
@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/create/users")
	public ResponseEntity<User> createUser(@RequestBody User user) throws HelpNowException{
		
			User userData = userService.createUser(user);
			return new ResponseEntity<>(userData, HttpStatus.CREATED);
		
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers() {

		try {
			List<User> userList = userService.findAllUser();
			return new ResponseEntity<>(userList, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
