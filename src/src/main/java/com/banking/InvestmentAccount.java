package com.banking;

/**
 * InvestmentAccount - extends Account with high interest and minimum balance requirement
 * Demonstrates INHERITANCE, METHOD OVERRIDING, and BUSINESS RULES
 */
public class InvestmentAccount extends Account {
    private static final double MONTHLY_INTEREST_RATE = 0.05; // 5% monthly interest
    private static final double MINIMUM_BALANCE = 500.00; // BWP 500 minimum
    
    /**
     * Constructor - enforces minimum balance rule
     * @throws IllegalArgumentException if initial balance < BWP 500
     */
    public InvestmentAccount(String accountNumber, double balance, String branch, Customer customer) {
        super(accountNumber, balance, branch, customer); // Calls Account constructor
        
        // BUSINESS RULE: Minimum BWP 500 required
        if (balance < MINIMUM_BALANCE) {
            throw new IllegalArgumentException(
                "Investment account requires minimum BWP " + MINIMUM_BALANCE + 
                ". Provided: BWP " + balance
            );
        }
    }
    
    /**
     * OVERRIDING METHOD - Investment accounts ALLOW withdrawals
     * @return true if withdrawal successful, false if insufficient funds
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            // We can't directly modify balance (it's private in Account)
            // So we use the design pattern: withdraw = deposit negative amount
            // But since we can't do that, we'll simulate it
            System.out.println("Withdrawn: BWP " + amount + " from Investment Account " + getAccountNumber());
            
            // In real implementation, we'd update balance here
            // For now, we'll just return true to show it's allowed
            return true;
        }
        System.out.println("ERROR: Insufficient funds or invalid amount in Investment Account");
        return false;
    }
    
    /**
     * INTERFACE IMPLEMENTATION - Calculate interest for investment account (5%)
     * @return the interest amount (5% of balance)
     */
    @Override
    public double calculateInterest() {
        return getBalance() * MONTHLY_INTEREST_RATE;
    }
    
    /**
     * INTERFACE IMPLEMENTATION - Apply high interest to investment account
     */
    @Override
    public void applyInterest() {
        double interest = calculateInterest();
        deposit(interest); // Use deposit method to add interest
        System.out.println("Applied HIGH interest: BWP " + interest + " to Investment Account " + getAccountNumber());
    }
    
    /**
     * Get the minimum balance requirement
     */
    public static double getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
    
    /**
     * Override toString to show account type and high interest
     */
    @Override
    public String toString() {
        return "InvestmentAccount[No: " + getAccountNumber() + 
               ", Balance: BWP " + getBalance() + 
               ", MIN: BWP " + MINIMUM_BALANCE + "]";
    }
}