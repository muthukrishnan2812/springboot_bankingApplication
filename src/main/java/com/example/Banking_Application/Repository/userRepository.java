package com.example.Banking_Application.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_Application.Entity.User;

public interface userRepository extends JpaRepository<User, Long> {
	
	List<User> findByName(String name);
	Optional<User> findByEmail(String email);

}
