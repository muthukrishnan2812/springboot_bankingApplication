package com.example.Banking_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_Application.Entity.Account;
import com.example.Banking_Application.Service.accountService;

@RestController
@CrossOrigin(origins = "https://lucent-marigold-cb4871.netlify.app")
@RequestMapping("/api/account")
public class accountController {
	
	@Autowired
	private accountService accServ;
	
	@PostMapping("/createAccount/{uid}")
	public ResponseEntity<String> createAccount(@PathVariable long uid,@RequestBody Account a){
		return accServ.createAccount(uid, a);
	}
	
	@GetMapping("/getAccountById/{aid}")
	public ResponseEntity<Account> getAccountByUserId(@PathVariable Long aid){
		return accServ.getAccountById(aid);
	}
	
	@DeleteMapping("/delete/{uid}/account/{aid}")
	public ResponseEntity<String> deleteAccount(@PathVariable Long uid, @PathVariable Long aid){
		return accServ.deleteAccountById(uid, aid);
	}
	
	@GetMapping("/getAccountByUserId/{userId}")
	public ResponseEntity<List<Account>> getAccountByUserId(@PathVariable long userId){
		return accServ.getAccountByUserId(userId);
	}

}
