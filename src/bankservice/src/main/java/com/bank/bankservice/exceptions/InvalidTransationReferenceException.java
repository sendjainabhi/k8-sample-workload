package com.bank.bankservice.exceptions;

/**
        * This Class is global exception handler class.
        * @author - Abhishek
        */

public class InvalidTransationReferenceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidTransationReferenceException(String errorMessage) {
        super(errorMessage);
    }


}