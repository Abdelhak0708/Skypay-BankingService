package com.skypay.bank.test;

import com.skypay.bank.exceptions.InsufficientBalanceException;
import com.skypay.bank.exceptions.NegativeAmountException;
import com.skypay.bank.model.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class AccountTest {
    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(3000);
    }

    @Test
    void testDepositOperation() {
        account.deposit(500);
        Assertions.assertEquals("3500",Integer.toString(account.getBalence()));
    }

    @Test
    void testWhithDrawOperation() {
        account.withdraw(500);
        Assertions.assertEquals("2500",Integer.toString(account.getBalence()));
    }

    @Test
    void testPrintStatement() {
        account.withdraw(500);
        Assertions.assertTrue(account.getAcountOperations().get(0).toString().contains("500"));
    }

    @Test
    void testInsufficientBalance() {
        assertThrows(InsufficientBalanceException.class, () -> {
            account.withdraw(4000);
        });
    }

    @Test
    void testNegativeAmount() {
        assertThrows(NegativeAmountException.class, () -> {
            account.deposit(-500);
        });
    }
}

