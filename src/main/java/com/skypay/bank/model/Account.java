package com.skypay.bank.model;

import com.skypay.bank.exceptions.InsufficientBalanceException;
import com.skypay.bank.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.Date;

public class Account implements AccountService {

    private int balance;
    private ArrayList<Operation> acountOperations = new ArrayList<>();

    public Account (int balence) {
        this.balance = balence;
    }

    public Account () {};

    public int getBalence(){
        return balance;
    }

    public ArrayList<Operation> getAcountOperations(){
        return acountOperations;
    }

    @Override
    public void deposit(int amount) {
        if(amount > 0) {
            Operation operation = new Operation(new Date(), amount, balance = amount + balance,OperationType.CREDIT);
            acountOperations.add(0, operation);
        }
        else {
            throw new NegativeAmountException("amount must be positive");
        }
    }

    @Override
    public void withdraw(int amount){

        if (amount > 0){
            if (amount <= balance) {
                Operation operation = new Operation(new Date(), amount, balance = balance - amount, OperationType.DEBIT);
                acountOperations.add(0, operation);
            } else {
                throw new InsufficientBalanceException("Amount must be less than the balance");
            }
        }
        else {
            throw new NegativeAmountException("amount must be positive");
        }
    }

    @Override
    public void printStatement() {
        if (acountOperations.size() == 0 ){
            System.out.println("No operations found for this account");
        }
        else {
            System.out.println("Date       || Amount || Balence");
            acountOperations.stream().forEach(System.out::println);
        }
    }
}
