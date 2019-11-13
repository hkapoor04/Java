package com.uis.assignments.cs501.week9;

public class Test {

    public static void main (String[] args) {
        Account account = new Account(1122, 20000);
        Account.setAnnualInterestRate(4.5);

        account.withdraw(2500);
        account.deposit(3000);
        System.out.println("Balance is " + account.getBalance());
        System.out.println("Monthly interest is " +
                account.getMonthlyInterestRate());
        System.out.println("This account was created at " +
                account.getDateCreated());
    }

}
