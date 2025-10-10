package com.banking;

/**
 * SavingsAccount - extends Account and implements specific savings rules
 * Demonstrates INHERITANCE and METHOD OVERRIDING
 */
public class SavingsAccount extends Account {
    private static final double MONTHLY_INTEREST_RATE = 0.0005; // 0.05% monthly interest
    
    /**
     * Constructor - calls parent constructor using super()
     */
    public SavingsAccount(String accountNumber, double balance, String branch, Customer customer) {
        super(accountNumber, balance, branch, customer); // Calls Account constructor
    }
    
    /**
     * OVERRIDING METHOD - Savings accounts do NOT allow withdrawals
     * @return always false (withdrawals not allowed)
     */
    @Override
    public boolean withdraw(double amount) {
        System.out.println("ERROR: Withdrawals not allowed from Savings Account " + getAccountNumber());
        return false; // Savings accounts don't allow withdrawals
    }
    
    /**
     * INTERFACE IMPLEMENTATION - Calculate interest for savings account
     * @return the interest amount (0.05% of balance)
     */
    @Override
    public double calculateInterest() {
        return getBalance() * MONTHLY_INTEREST_RATE;
    }
    
    /**
     * INTERFACE IMPLEMENTATION - Apply interest to savings account
     */
    @Override
    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest); // Use deposit method to add interest (ENCAPSULATION)
        System.out.println("Applied interest: BWP " + interest + " to Savings Account " + getAccountNumber());
    }
    
    /**
     * Override toString to show account type
     */
    @Override
    public String toString() {
        return "SavingsAccount[No: " + getAccountNumber() + ", Balance: BWP " + getBalance() + "]";
    }
}