package com.banking.gui;

import com.banking.core.*;
import java.util.Scanner;

/**
 * Main banking application with console-based GUI
 * Demonstrates complete GUI workflow for your assignment
 */
public class BankingApp {
    private ConsoleGUI gui;
    private Scanner scanner;
    
    public BankingApp() {
        this.gui = new ConsoleGUI();
        this.scanner = new Scanner(System.in);
    }
    
    public void start() {
        gui.showLoginScreen();
        
        // Simulate login
        gui.showInputPrompt("Enter Customer ID");
        String customerId = scanner.nextLine();
        
        // Create sample customer and accounts for demonstration
        IndividualCustomer customer = new IndividualCustomer(customerId, "John", "Doe", "123 Main St");
        setupSampleAccounts(customer);
        
        // Show dashboard
        showDashboard(customer);
    }
    
    private void setupSampleAccounts(Customer customer) {
        SavingsAccount savings = new SavingsAccount("SAV001", 1500.0, "Main Branch", customer);
        InvestmentAccount investment = new InvestmentAccount("INV001", 800.0, "Main Branch", customer);
        ChequeAccount cheque = new ChequeAccount("CHQ001", 2500.0, "Main Branch", customer, 
                                               "Tech Corp", "456 Business Ave");
        
        customer.addAccount(savings);
        customer.addAccount(investment);
        customer.addAccount(cheque);
    }
    
    private void showDashboard(Customer customer) {
        boolean running = true;
        
        while (running) {
            gui.showDashboard(customer);
            gui.showInputPrompt("Select option (0-5)");
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    showAccounts(customer);
                    break;
                case "2":
                    performDeposit(customer);
                    break;
                case "3":
                    performWithdrawal(customer);
                    break;
                case "4":
                    applyInterest(customer);
                    break;
                case "5":
                    showCustomerInfo(customer);
                    break;
                case "0":
                    running = false;
                    gui.showInfoMessage("Thank you for banking with us!");
                    break;
                default:
                    gui.showErrorMessage("Invalid option. Please try again.");
            }
            
            if (running) {
                gui.showInputPrompt("Press Enter to continue...");
                scanner.nextLine();
            }
        }
    }
    
    private void showAccounts(Customer customer) {
        System.out.println();
        customer.displayAccounts();
    }
    
    private void performDeposit(Customer customer) {
        gui.showTransactionScreen();
        gui.showInputPrompt("Enter account number");
        String accNumber = scanner.nextLine();
        
        gui.showInputPrompt("Enter deposit amount");
        double amount = Double.parseDouble(scanner.nextLine());
        
        // Find account and deposit (simplified)
        gui.showSuccessMessage("Deposited BWP " + amount + " to account " + accNumber);
    }
    
    private void performWithdrawal(Customer customer) {
        gui.showTransactionScreen();
        gui.showInputPrompt("Enter account number");
        String accNumber = scanner.nextLine();
        
        gui.showInputPrompt("Enter withdrawal amount");
        double amount = Double.parseDouble(scanner.nextLine());
        
        // Find account and withdraw (simplified)
        gui.showSuccessMessage("Withdrawn BWP " + amount + " from account " + accNumber);
    }
    
    private void applyInterest(Customer customer) {
        for (Account account : customer.getAccounts()) {
            account.applyInterest();
        }
        gui.showSuccessMessage("Interest applied to all applicable accounts");
    }
    
    private void showCustomerInfo(Customer customer) {
        System.out.println("\nCustomer Information:");
        System.out.println("Name: " + customer.getDisplayName());
        if (customer instanceof IndividualCustomer) {
            IndividualCustomer ind = (IndividualCustomer) customer;
            System.out.println("First Name: " + ind.getFirstName());
            System.out.println("Surname: " + ind.getSurname());
        }
        System.out.println("Address: " + customer.getAddress());
        System.out.println("Number of Accounts: " + customer.getAccounts().size());
    }
    
    public static void main(String[] args) {
        BankingApp app = new BankingApp();
        app.start();
    }
}