package com.developers.jobalert.service;

import java.util.List;
import java.util.Optional;

import com.developers.jobalert.entity.User;


public interface UserService {

	public User saveUser(User user);

	public Optional<User> findUserById(Long id);

	public List<User> findAllUsers();

	public User updateUser(Long id, User user);

	public void deleteUserById(Long id);
}
