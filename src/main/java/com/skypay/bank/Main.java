package com.skypay.bank;

import com.skypay.bank.model.Account;

public class Main {
    public static void main(String[] args) {

        try {
            Account account = new Account();

            account.deposit(1000);
            account.deposit(2000);
            account.withdraw(500);
            account.printStatement();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
