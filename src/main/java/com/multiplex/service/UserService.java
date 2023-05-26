package com.multiplex.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.entity.User;
import com.multiplex.exception.InvalidEmailException;
import com.multiplex.exception.InvalidMobileNumberException;
import com.multiplex.exception.UserAlreadyExistException;
import com.multiplex.exception.UserNotFoundException;
import com.multiplex.repository.UserDao;





@Service
public class UserService implements IUserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<User> getAllUsers() {
		return userDao.findAll();
	}

	@Override
	public User addUserDetails(User user) throws Exception {
		
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmailId());
		
		if(!matcher.matches()){
			throw new InvalidEmailException("Please enter a valid mail.\n ex: abc@gmail.com");
		}else if(user.getMobileNumber().length() != 10 || !user.getMobileNumber().matches("[0-9]+")) {
			throw new InvalidMobileNumberException("Please enter a valid 10 digit mobile number. \n ex: 9123456789");
		}
		
		List<User> list = userDao.findAll();
		for (User u : list) {
			if (u.getUserId() == user.getUserId()) {
				throw new UserAlreadyExistException("User already exists...");
			}
		}
		return userDao.save(user);
	}

	@Override
	public User updateUserDetails(User user) {
		return userDao.save(user);
	}

	@Override
	public User showUserDetails(int userId) throws UserNotFoundException {
		try {
			return userDao.findById(userId).get();
		} catch (Exception e) {
			throw new UserNotFoundException("User not found...");
		}
	}

	@Override
	public void deleteUserDetails(int userId) throws UserNotFoundException {
		try {
			userDao.deleteById(userId);
		} catch (Exception e) {
			throw new UserNotFoundException("User not found...");
		}
	}

}
