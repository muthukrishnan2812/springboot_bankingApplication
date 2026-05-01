package com.example.Banking_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Banking_Application.Entity.Loan;

public interface loanRepository extends JpaRepository<Loan, Long> {
	
	List<Loan> findByUserId(long id);

}
