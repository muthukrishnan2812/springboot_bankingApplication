package com.example.Banking_Application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Banking_Application.Entity.Loan;
import com.example.Banking_Application.Service.LoanService;
import com.example.Banking_Application.Service.userService;

@RestController
@CrossOrigin(origins = "https://lucent-marigold-cb4871.netlify.app")
@RequestMapping("/api/loan")
public class loanController {
	
	@Autowired
	private userService userServ;
	@Autowired
	private LoanService loanServ;
	
	@PostMapping("/applyLoan/{uid}")
	public ResponseEntity<String> applyLoan(@PathVariable Long uid,@RequestBody Loan l) {
		return loanServ.applyLoan(uid, l);
	}
	
	@GetMapping("/getByLoan/{lid}")
	public ResponseEntity<Loan> getByLoan(@PathVariable long lid) {
		return loanServ.getLoanById(lid);
	}
	
	@DeleteMapping("/delete/user/{uid}/loan/{lid}")
	public ResponseEntity<String> deleteLoan(@PathVariable Long uid,@PathVariable Long lid) {
		return loanServ.deleteLoan(uid, lid);
	}
	
	
	
	

}
