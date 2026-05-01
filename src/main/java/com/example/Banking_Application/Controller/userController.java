package com.example.Banking_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_Application.Entity.User;
import com.example.Banking_Application.Service.userService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/user")
public class userController {
	
	@Autowired
	public userService service;
	
	//save
	@PostMapping("/save")
	public User createUser(@RequestBody User u) {
		return service.saveUser(u);
	}
	
	@GetMapping("/getById/{id}")
	public User getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable long id) {
		return service.deleteById(id);
	}
	
	@PostMapping("/login")
	public User loginUser(@RequestBody User u) {
		User user = service.loginUser(u.getEmail(), u.getPassword());
		return user;
	}

}
