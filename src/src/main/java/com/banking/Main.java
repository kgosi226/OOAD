package com.banking;

/**
 * Main class to demonstrate the banking system functionality
 * Tests all OOP concepts: Inheritance, Polymorphism, Encapsulation, Abstraction
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== BANKING SYSTEM DEMONSTRATION ===");
        System.out.println("Demonstrating OOP Principles in Java\n");
        
        // Create a customer
        Customer customer1 = new Customer("CUST001", "John", "Doe", "123 Main Street");
        System.out.println("✅ Created Customer: " + customer1.getFullName());
        
        try {
            // ========== DEMONSTRATING INHERITANCE & POLYMORPHISM ==========
            System.out.println("\n--- CREATING ACCOUNTS (Inheritance) ---");
            
            // Create different types of accounts for the same customer
            SavingsAccount savings = new SavingsAccount("SAV001", 1000.0, "Main Branch", customer1);
            InvestmentAccount investment = new InvestmentAccount("INV001", 600.0, "Main Branch", customer1);
            ChequeAccount cheque = new ChequeAccount("CHQ001", 2000.0, "Main Branch", customer1, 
                                                    "Tech Corp", "456 Business Avenue");
            
            // Add accounts to customer
            customer1.addAccount(savings);
            customer1.addAccount(investment);
            customer1.addAccount(cheque);
            
            System.out.println("✅ Created 3 different account types for customer");
            
            // ========== DEMONSTRATING POLYMORPHISM ==========
            System.out.println("\n--- TESTING DEPOSITS (Common Behavior) ---");
            savings.deposit(500);
            investment.deposit(200);
            cheque.deposit(1000);
            
            // ========== DEMONSTRATING METHOD OVERRIDING ==========
            System.out.println("\n--- TESTING WITHDRAWALS (Polymorphism) ---");
            System.out.print("Savings Account: ");
            savings.withdraw(100);  // Should FAIL
            
            System.out.print("Investment Account: ");
            investment.withdraw(100); // Should SUCCEED
            
            System.out.print("Cheque Account: ");
            cheque.withdraw(500);   // Should SUCCEED
            
            // ========== DEMONSTRATING INTERFACE POLYMORPHISM ==========
            System.out.println("\n--- TESTING INTEREST (Interface Polymorphism) ---");
            savings.applyInterest();    // 0.05% interest
            investment.applyInterest(); // 5% interest
            cheque.applyInterest();     // No interest
            
            // ========== DEMONSTRATING ENCAPSULATION ==========
            System.out.println("\n--- TESTING ENCAPSULATION ---");
            System.out.println("Customer balance access via getters:");
            for (Account account : customer1.getAccounts()) {
                System.out.println("  - " + account.getAccountNumber() + 
                                 ": BWP " + account.getBalance());
            }
            
            // ========== FINAL SUMMARY ==========
            System.out.println("\n=== FINAL SYSTEM STATE ===");
            customer1.displayAccounts();
            
            // Test employment info (ChequeAccount specific)
            System.out.println("\n--- EMPLOYMENT INFORMATION (Cheque Account) ---");
            cheque.displayEmploymentInfo();
            
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        
        System.out.println("\n=== DEMONSTRATION COMPLETE ===");
        System.out.println("OOP Principles Demonstrated:");
        System.out.println("✅ Abstraction (Account abstract class)");
        System.out.println("✅ Inheritance (Accounts extend Account)");
        System.out.println("✅ Polymorphism (Different withdraw/interest behaviors)");
        System.out.println("✅ Encapsulation (Private attributes with public getters)");
        System.out.println("✅ Interface Implementation (InterestBearing)");
    }
}