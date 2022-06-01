package com.bank.bankservice.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import com.bank.bankservice.model.Transaction;
import com.bank.bankservice.model.User;
import com.bank.bankservice.repository.TransactionRepository;
import com.bank.bankservice.repository.UserRepository;

/**
 * This Class is persistence class for all crud operations
 * @author - Abhishek
 */

@ComponentScan
@Service
public class TransactionService {

	 @Autowired // This means to get the bean called userRepository
     // Which is auto-generated by Spring, we will use it to handle the data
	 private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }
    
    public void saveUser(User user) {
    	userRepository.save(user);
    }


    public Iterable<User> getallUsers() {
        return userRepository.findAll();
    }
    
    public Iterable<Transaction> getTransactionHistory() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }
}