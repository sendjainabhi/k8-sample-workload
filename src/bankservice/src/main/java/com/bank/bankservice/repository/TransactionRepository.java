package com.bank.bankservice.repository;

import com.bank.bankservice.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
* This Class is persistence class for all crud operations
* @author - Abhishek
*/

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}