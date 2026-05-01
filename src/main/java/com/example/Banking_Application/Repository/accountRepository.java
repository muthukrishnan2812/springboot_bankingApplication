package com.example.Banking_Application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Banking_Application.Entity.Account;

public interface accountRepository extends JpaRepository<Account, Long> {
	
	@Query(value ="select a from Account a where a.user.id= ?1")
	List<Account> getAccountByUserId(Long id);

}
