package com.skypay.bank.model;

public interface AccountService {
    void deposit(int amount);
    void withdraw(int amount);
    void printStatement();
}
