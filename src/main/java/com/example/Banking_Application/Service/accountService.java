package com.example.Banking_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Banking_Application.Entity.Account;
import com.example.Banking_Application.Entity.User;
import com.example.Banking_Application.Exception.ResourceNotFoundException;
import com.example.Banking_Application.Repository.accountRepository;
import com.example.Banking_Application.Repository.userRepository;

import jakarta.transaction.Transactional;

@Service
public class accountService {
	
	@Autowired
	private accountRepository accRepo;
	
	@Autowired
	private userRepository userRepo;
	
	@Transactional
	public ResponseEntity<String> createAccount(Long uid, Account acc) {
		User u = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "Uid", uid));
		
		u.addAccount(acc);
		userRepo.save(u);
		return new ResponseEntity<String>("Account created",HttpStatus.CREATED);
	}
	
	public ResponseEntity<Account> getAccountById(Long id) {
		Account a = accRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Account", "Aid", id));
		return new ResponseEntity<Account>(a,HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteAccountById(Long uid, Long aid){
		User u = userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundException("User", "user id", uid));
		
		Account a = accRepo.findById(aid).orElseThrow(()-> new ResourceNotFoundException("Account", "aid", aid));
		
		u.removeAccount(a);
		
		accRepo.delete(a);
		
		return new ResponseEntity<String>("Account deleted", HttpStatus.OK);
	}
	
	public ResponseEntity<List<Account>> getAccountByUserId(long id){
		List<Account> a = accRepo.getAccountByUserId(id);
		
		return new ResponseEntity<List<Account>>(a,HttpStatus.OK);
	}

}
