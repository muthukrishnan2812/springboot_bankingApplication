package com.example.Banking_Application.Entity;


import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name should not be blank")
	private String name;
	@Email(message = "Enter valid Email")
	@Column(unique = true, nullable = false)
	private String email;
	@NotBlank(message = "Password should not be blank")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private Set<Loan> loans;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	@JsonIgnore
	private Set<Account> accounts;
	
	

	public void addLoan(Loan loan) {
		loans.add(loan);
		loan.setUser(this);
	}
	
	public void removeLoan(Loan loan) {
		loans.remove(loan);
		loan.setUser(null);
	}
	
	public void addAccount(Account acc) {
		accounts.add(acc);
		acc.setUser(this);
	}
	
	public void removeAccount(Account acc) {
		accounts.remove(acc);
		acc.setUser(this);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Loan> getLoans() {
		return loans;
	}
	public void setLoans(Set<Loan> loans) {
		this.loans = loans;
	}
	
	

}
