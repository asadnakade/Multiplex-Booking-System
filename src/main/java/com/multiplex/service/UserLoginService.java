package com.multiplex.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.multiplex.entity.User;
import com.multiplex.entity.UserLogin;
import com.multiplex.repository.UserLoginDao;
@Service
public class UserLoginService implements IUserLoginService {
@Autowired
private UserLoginDao userlogindao;
private User user;
@Override
public List<UserLogin> getAllUserLogin(){
return userlogindao.findAll();
// String s = user.getPassword();
// return s;
}
@Override
public UserLogin addUserLogin(UserLogin userlogin) {
return userlogindao.save(userlogin);
}
@Override
public UserLogin updateUserLogin(UserLogin userlogin) {
return userlogindao.save(userlogin);
}
@Override
public UserLogin getUserLoginById(Integer userid) {
return userlogindao.findById(userid).get();
}
@Override
public void deleteUserLoginById(Integer userid) {
userlogindao.deleteById(userid);
}
}