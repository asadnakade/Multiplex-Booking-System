package com.multiplex.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.multiplex.entity.UserLogin;
public interface UserLoginDao extends JpaRepository<UserLogin, Integer> {
}