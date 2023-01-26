package com.developers.jobalert.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developers.jobalert.entity.User;
import com.developers.jobalert.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	private static Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserRepository userRepository;

	@Override
	public User saveUser(User user) {
		user.setJobAlertId(UUID.randomUUID().toString());
		user.setCreatedDate(new Date());
		LOGGER.debug(" saveUser method is called in service");
		return userRepository.save(user);
	}

	@Override
	public Optional<User> findUserById(Long id) {
		LOGGER.debug("findUserById()  method is called in service");
		return userRepository.findById(id);
	}

	@Override
	public List<User> findAllUsers() {
		LOGGER.debug("findAllUsers()  method is called in service");
		return userRepository.findAll();
	}

	@Override
	public User updateUser(Long id, User user) {
		LOGGER.debug("updateBlog()  method is called in service");
		Optional<User> optionalBlog = userRepository.findById(id);
		User updateUser = optionalBlog.get();
		updateUser.setFullName(user.getFullName());
		updateUser.setPassword(user.getPassword());
		return userRepository.save(updateUser);
	}

	@Override
	public void deleteUserById(Long id) {
		LOGGER.debug("deleteUserById()  method is called in service");
		userRepository.deleteById(id);
	}
	
}
