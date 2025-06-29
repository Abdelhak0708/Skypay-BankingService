package com.skypay.bank.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Operation {
    private Date date;

    private int amount;

    private int balence;

    OperationType operationType;

    public Operation(Date date, int amount, int balence, OperationType operationType) {
        this.date = date;
        this.amount = amount;
        this.balence = balence;
        this.operationType = operationType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBalence() {
        return balence;
    }

    public void setBalence(int balence) {
        this.balence = balence;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return (
                (dateFormat.format(date)) +
                " || " + ((operationType.equals(OperationType.CREDIT)) ? amount  : ("-" + amount))
                        +
                " ||   " + balence
        );
    }
}

