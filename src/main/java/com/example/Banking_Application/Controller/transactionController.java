package com.example.Banking_Application.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_Application.Entity.Transaction;
import com.example.Banking_Application.Service.transactionService;

@RestController
@CrossOrigin(origins = "https://lucent-marigold-cb4871.netlify.app")
@RequestMapping("/api/transaction")
public class transactionController {
	
	@Autowired
	private transactionService transService;
	
	@PostMapping("/pay/{userId}")
	public ResponseEntity<String> sendTransaction(@PathVariable long userId,@RequestBody Transaction t) {
		return transService.addTransaction(userId, t);
	}
	
	@GetMapping("/getTransaction/{userId}")
	
	public ResponseEntity<List<Transaction>> getAllTransaction(@PathVariable long userId) {
		return transService.getAllTransactionByUser(userId);
	}

}
