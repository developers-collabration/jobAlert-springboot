package com.developers.jobalert.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.developers.jobalert.entity.User;
import com.developers.jobalert.service.UserService;

@RestController
@RequestMapping("/api/v1/jobAlert/")
public class UserController {

	private static Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/User")
	public ResponseEntity<User> createUser(@RequestBody User User) {
		LOGGER.debug("createUser()  method is called in controller");
		return new ResponseEntity<User>(userService.saveUser(User), HttpStatus.CREATED);
	}

	@GetMapping("/User/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		LOGGER.debug("getUserById()  method is called in controller");
		return new ResponseEntity<User>(userService.findUserById(id).get(), HttpStatus.OK);
	}

	@GetMapping("/Users")
	public ResponseEntity<List<User>> getAllUsers() {
		LOGGER.debug("getAllUsers()  method is called in controller");
		return new ResponseEntity<List<User>>(userService.findAllUsers(), HttpStatus.OK);
	}

	@PutMapping("User/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User User) {
		LOGGER.debug("updateUser()  method is called in controller");
		return new ResponseEntity<User>(userService.updateUser(id, User), HttpStatus.OK);
	}
	@DeleteMapping("User/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id) {
		LOGGER.debug("deleteUser()  method is called in controller");
		Map<String, Long> map = new HashMap<>();
		map.put("deleted successfully", id);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
