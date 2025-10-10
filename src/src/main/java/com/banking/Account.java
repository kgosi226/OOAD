package com.banking;

/**
 * Abstract base class for all bank accounts
 * Implements InterestBearing interface - all accounts must handle interest
 * Cannot create Account objects directly - must use specific account types
 */
public abstract class Account implements InterestBearing {
    // PRIVATE ATTRIBUTES (Encapsulation - data protection)
    private String accountNumber;
    private double balance;
    private String branch;
    private Customer customer;
    
    /**
     * Constructor for Account - called when creating Savings/Investment/Cheque accounts
     */
    public Account(String accountNumber, double initialBalance, String branch, Customer customer) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.branch = branch;
        this.customer = customer;
    }
    
    // PUBLIC GETTER METHODS (Encapsulation - controlled access)
    public String getAccountNumber() { 
        return accountNumber; 
    }
    
    public double getBalance() { 
        return balance; 
    }
    
    public String getBranch() { 
        return branch; 
    }
    
    public Customer getCustomer() { 
        return customer; 
    }
    
    /**
     * Deposit money into account - common behavior for ALL account types
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: BWP " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Error: Deposit amount must be positive");
        }
    }
    
    /**
     * ABSTRACT METHOD - each specific account type must define its own withdrawal rules
     */
    public abstract boolean withdraw(double amount);
    
    /**
     * Common method for all accounts
     */
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "[Account: " + accountNumber + ", Balance: BWP " + balance + "]";
    }
}