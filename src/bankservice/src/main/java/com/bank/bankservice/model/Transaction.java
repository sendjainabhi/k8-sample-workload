package com.bank.bankservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This Class is model/bean class.
 * @author - Abhishek
 */
@Entity (name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long transactionId;
   
    @javax.persistence.Column(name = "from_account")
    private int fromAccount;
    
    @javax.persistence.Column(name = "to_account")
    private int toAccount;
    
    @javax.persistence.Column(name = "amount")
    private int amount;

    public Transaction (){
    }
    public long getTransactionId() {
        return transactionId;
    }
    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }
   
      
	/**
	 * @return the fromAccount
	 */
	public int getFromAccount() {
		return fromAccount;
	}
	/**
	 * @param fromAccount the fromAccount to set
	 */
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	/**
	 * @return the toAccount
	 */
	public int getToAccount() {
		return toAccount;
	}
	/**
	 * @param toAccount the toAccount to set
	 */
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
    public String toString() {
        return "Transaction [fromAccount=" + fromAccount + ", toAccount=" + toAccount +", amount=" + amount + "]";
    }
}