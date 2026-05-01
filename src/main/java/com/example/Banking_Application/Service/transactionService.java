package com.example.Banking_Application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Banking_Application.Entity.Account;
import com.example.Banking_Application.Entity.Transaction;
import com.example.Banking_Application.Exception.ResourceNotFoundException;
import com.example.Banking_Application.Repository.accountRepository;
import com.example.Banking_Application.Repository.transactionRepository;


@Service
public class transactionService {
	@Autowired
	private transactionRepository transRepo;
	
	@Autowired
	private accountRepository accRepo;
	
	public ResponseEntity<String> addTransaction(long accountId, Transaction transaction) {

		Account account = accRepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("Account", "AccountId", accountId));
		account.addTransaction(transaction);
		transRepo.save(transaction);
		return new ResponseEntity<>("transaction added", HttpStatus.CREATED);
	}
	
	public ResponseEntity<List<Transaction>> getAllTransactionByUser(long userId){
		List<Transaction> transactions = transRepo.findByAccountUserId(userId);
		
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

}
