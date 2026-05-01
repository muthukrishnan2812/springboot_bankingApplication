package com.example.Banking_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Banking_Application.Entity.Loan;
import com.example.Banking_Application.Entity.User;
import com.example.Banking_Application.Exception.ResourceNotFoundException;
import com.example.Banking_Application.Repository.loanRepository;
import com.example.Banking_Application.Repository.userRepository;

import jakarta.transaction.Transactional;

@Service
public class LoanService {
	@Autowired
	private userRepository userRepo;
	@Autowired
	private loanRepository loanRepo;
	
	@Transactional
	public ResponseEntity<String> applyLoan(long userId, Loan loan) {
		User u = userRepo.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "User Id", userId));
		
		u.addLoan(loan);
		userRepo.save(u);
		return new ResponseEntity<String>("Loan applied", HttpStatus.CREATED);
	}
	
	public ResponseEntity<Loan> getLoanById(Long id) {
		Loan l = loanRepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Loan", "Loan Id", id));
		
		return new ResponseEntity<Loan>(l, HttpStatus.OK);
	}
	
	public ResponseEntity<String> deleteLoan(Long userId, Long loanId) {
		User u = userRepo.findById(userId).
				orElseThrow(()-> new ResourceNotFoundException("User", "User id", userId));
		
		Loan l = loanRepo.findById(loanId).
				orElseThrow(()-> new ResourceNotFoundException("Loan", "Loan Id", loanId));
		
		u.removeLoan(l);
		
		loanRepo.delete(l);
		
		return new ResponseEntity<String>("Loan deleted", HttpStatus.OK);
	}
	
	public List<Loan> getLoanByUserId(long userId){
		return loanRepo.findByUserId(userId);
	}
	
	public String getLoanStatus(long id) {
		Loan l = loanRepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Loan", "Loan Id", id));
		
		return l.getStatus();
	}
}
