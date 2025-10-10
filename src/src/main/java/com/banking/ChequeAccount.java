package com.banking;

/**
 * ChequeAccount - extends Account with employment information requirement
 * Used for salary payments, allows withdrawals but pays no interest
 * Demonstrates INHERITANCE and ADDITIONAL ATTRIBUTES
 */
public class ChequeAccount extends Account {
    // ADDITIONAL ATTRIBUTES specific to ChequeAccount
    private String companyName;
    private String companyAddress;
    
    /**
     * Constructor - requires employment information
     */
    public ChequeAccount(String accountNumber, double balance, String branch, 
                        Customer customer, String companyName, String companyAddress) {
        super(accountNumber, balance, branch, customer); // Calls Account constructor
        this.companyName = companyName;
        this.companyAddress = companyAddress;
    }
    
    /**
     * OVERRIDING METHOD - Cheque accounts ALLOW withdrawals (like Investment accounts)
     * @return true if withdrawal successful, false if insufficient funds
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            System.out.println("Withdrawn: BWP " + amount + " from Cheque Account " + getAccountNumber());
            // In real implementation, we'd update balance here
            return true;
        }
        System.out.println("ERROR: Insufficient funds or invalid amount in Cheque Account");
        return false;
    }
    
    /**
     * INTERFACE IMPLEMENTATION - Cheque accounts pay NO interest
     * @return always 0 (no interest)
     */
    @Override
    public double calculateInterest() {
        return 0.0; // Cheque accounts don't earn interest
    }
    
    /**
     * INTERFACE IMPLEMENTATION - No interest to apply
     */
    @Override
    public void applyInterest() {
        System.out.println("No interest applied to Cheque Account " + getAccountNumber() + " (salary account)");
    }
    
    // GETTERS for employment information
    public String getCompanyName() { 
        return companyName; 
    }
    
    public String getCompanyAddress() { 
        return companyAddress; 
    }
    
    /**
     * Override toString to show employment information
     */
    @Override
    public String toString() {
        return "ChequeAccount[No: " + getAccountNumber() + 
               ", Balance: BWP " + getBalance() + 
               ", Employer: " + companyName + "]";
    }
    
    /**
     * Display employment details
     */
    public void displayEmploymentInfo() {
        System.out.println("Employment details for account " + getAccountNumber() + ":");
        System.out.println("  Company: " + companyName);
        System.out.println("  Address: " + companyAddress);
    }
}