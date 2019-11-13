package com.uis.assignments.cs501.week9;

import java.util.Date;

class Account {

    //-- variable for id
    private int id;

    //-- variable for balance
    private double balance;

    //-- variable for annual interest rate
    private static double annualInterestRate;

    //-- variable for date created
    private Date dateCreated;

    //-- No argument constructor for creating default account object
    public Account(){
    }

    //-- Constructor for creating account with id and initial balance
    public  Account(int id, double initialBalance){
        this.id = id;
        this.balance = initialBalance;
    }

    //-- accessor and mutator methods for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //-- accessor and mutator methods for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //-- accessor and mutator methods for annualInterestRate
    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        Account.annualInterestRate = annualInterestRate;
    }

    //-- Accessor method for date created
    public String getDateCreated() {
        dateCreated = new Date();
        return dateCreated.toString();
    }

    /*
     * Method to calculate the monthly interest rate
     */
    public double getMonthlyInterestRate(){
        return Math.round((annualInterestRate / 12.0) * 10000.0) / 10000.0;
    }

    /*
     * Method to withdraw money from balance
     */
    public void withdraw(double withdrawAmount){
        balance =  balance - withdrawAmount;
    }

    /*
     * Method to deposit money into account
     */
    public void deposit(double depositAmount){
        balance = balance + depositAmount;
    }
}
