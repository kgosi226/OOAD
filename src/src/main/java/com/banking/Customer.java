package com.banking;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a bank customer who can own multiple accounts
 * Demonstrates composition - a Customer HAS multiple Accounts
 */
public class Customer {
    // PRIVATE ATTRIBUTES (Encapsulation)
    private String customerId;
    private String firstName;
    private String surname;
    private String address;
    private List<Account> accounts;  // A customer can have multiple accounts
    
    /**
     * Constructor to create a new customer
     */
    public Customer(String customerId, String firstName, String surname, String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.surname = surname;
        this.address = address;
        this.accounts = new ArrayList<>();  // Start with empty account list
    }
    
    // GETTER METHODS (Encapsulation - controlled access)
    public String getCustomerId() { 
        return customerId; 
    }
    
    public String getFirstName() { 
        return firstName; 
    }
    
    public String getSurname() { 
        return surname; 
    }
    
    public String getAddress() { 
        return address; 
    }
    
    public List<Account> getAccounts() { 
        return accounts; 
    }
    
    /**
     * Add an account to this customer
     * @param account the account to add
     */
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Added " + account.getClass().getSimpleName() + " to customer " + getFullName());
    }
    
    /**
     * Get the customer's full name
     */
    public String getFullName() {
        return firstName + " " + surname;
    }
    
    /**
     * Display all accounts for this customer
     */
    public void displayAccounts() {
        System.out.println("Accounts for " + getFullName() + ":");
        for (Account account : accounts) {
            System.out.println("  - " + account);
        }
    }
}