package com.skypay.bank.exceptions;

public class NegativeAmountException extends RuntimeException {
    public NegativeAmountException(String s) {
        super(s);
    }
}
