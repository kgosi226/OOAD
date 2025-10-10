package com.banking;

/**
 * Interface for accounts that can earn interest
 * This defines what interest-bearing accounts MUST do
 */
public interface InterestBearing {
    /**
     * Calculate how much interest should be paid
     * @return the interest amount
     */
    double calculateInterest();
    
    /**
     * Add the calculated interest to the account balance
     */
    void applyInterest();
}