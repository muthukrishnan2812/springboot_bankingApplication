package com.example.Banking_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Banking_Application.Entity.User;
import com.example.Banking_Application.Exception.ResourceNotFoundException;
import com.example.Banking_Application.Repository.userRepository;

@Service
public class userService {
	
	@Autowired
	public userRepository repo;
	
	public User saveUser(User u) {
		return repo.save(u);
	}
	
	public User getById(long id) {
		return repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User","id",id));
	}
	
	public String deleteById(long id) {
		repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User", "id", id));
		
		repo.deleteById(id);
		
		return "data deleted";
	}
	
	public List<User> searchByName(String name){
		List<User> l =repo.findByName(name);
		
		return l;
	}
	
	public User searchByEmail(String email) {
		User u	=repo.findByEmail(email).orElseThrow(()-> new RuntimeException("user not found") );
		
		return u;
		
	}
	
	public User loginUser(String email,String password) {
		User user = repo.findByEmail(email)
		        .orElseThrow(() -> new RuntimeException("User not found"));

		    if (!user.getPassword().equals(password)) {
		        throw new RuntimeException("Invalid password");
		    }
		    return user;
	}
	

}
