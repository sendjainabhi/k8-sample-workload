package com.bank.bankservice.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.bankservice.exceptions.InvalidTransationReferenceException;
import com.bank.bankservice.model.Transaction;
import com.bank.bankservice.model.User;
import com.bank.bankservice.service.TransactionService;

/**
 * This Class is Transaction Controller have all API endpoints.
 * 
 * @author - Abhishek
 */

@RestController
public class TransactionConroller {

	@Autowired
	TransactionService transactionService;

	@PostMapping(path = "/api/adduser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Integer addNewUser(@RequestParam String username , @RequestParam String email) {
	    User user = new User();
	    user.setName(username);
	    user.setEmail(email);
		transactionService.saveUser(user);
		return user.getId();
	}
	
	/*
	 * service endpoint to get all user record
	 */

	@GetMapping(path = "/api/allUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<User> getAllUsers() {
		// This returns a JSON or XML with the users
		return transactionService.getallUsers();
	}

	/*
	 * service endpoint to insert record
	 */
	@PostMapping(path = "/api/createTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public Long createTransaction(@RequestBody Transaction trx) {
		transactionService.saveTransaction(trx);
		return trx.getTransactionId();
	}

	/*
	 * service endpoint to view all transactions records
	 */
	@GetMapping(path = "/api/viewAllTransaction", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Transaction> viewAllTransactions() {
		return transactionService.getTransactionHistory();
	}

	/*
	 * service endpoint to view specific id record
	 */
	@GetMapping(path = "/api/view/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transaction viewTransactionById(@PathVariable("id") Long id) {
		Optional<Transaction> transaction = transactionService.getTransaction(id);
		if (transaction.isPresent()) {
			return transaction.get();
		}

		throw new InvalidTransationReferenceException("Invalid transaction reference provided");
	}
}