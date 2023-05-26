package com.multiplex.service;

import java.util.List;

import com.multiplex.entity.User;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;


public interface IUserService {

	public User addUserDetails(User user) throws Exception;

	public User updateUserDetails(User user);

	public User showUserDetails(int userId) throws UserNotFoundException;

	public List<User> getAllUsers();

	public void deleteUserDetails(int userId) throws UserNotFoundException;

}
