package com.example.Banking_Application.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Banking_Application.Entity.Transaction;

public interface transactionRepository extends JpaRepository<Transaction, Long>{
	
	List<Transaction> findByAccountUserId(Long userId);
	
	@Query(value = "select t from Transaction t where t.account.user.id = ?1 and t.date between ?2 and ?3")
	List<Transaction> getUserTransactionByDate(long userId, LocalDateTime st, LocalDateTime ed);
	
	@Query(value = "select t from Transaction t where t.account.user.id = ?1 and t.amount between ?2 and ?3")
	List<Transaction> getUserTransactionByAmount(long userId, double stamt, double edamt);

}
