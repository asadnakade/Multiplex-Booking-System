package com.multiplex.service;
import java.util.List;
import com.multiplex.entity.UserLogin;
public interface IUserLoginService {
public List<UserLogin> getAllUserLogin();
public UserLogin addUserLogin(UserLogin userlogin);
public UserLogin updateUserLogin(UserLogin userlogin);
public UserLogin getUserLoginById(Integer userid);
public void deleteUserLoginById(Integer userid);
}