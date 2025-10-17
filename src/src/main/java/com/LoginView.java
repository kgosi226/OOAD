package com.banking.gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Login View - Boundary class for user authentication
 * Demonstrates GUI implementation with JavaFX
 * NO business logic - only UI components
 */
public class LoginView extends Application {
    
    private TextField customerIdField;
    private PasswordField passwordField;
    private Button loginButton;
    private Label messageLabel;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Banking System - Login");
        
        // Create UI components
        Label titleLabel = new Label("Welcome to Banking System");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");
        
        Label customerIdLabel = new Label("Customer ID:");
        customerIdField = new TextField();
        customerIdField.setPromptText("Enter your customer ID");
        
        Label passwordLabel = new Label("Password:");
        passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        
        loginButton = new Button("Login");
        loginButton.setStyle("-fx-background-color:rgb(255, 251, 0); -fx-text-fill: white;");
        
        messageLabel = new Label();
        messageLabel.setStyle("-fx-text-fill: red;");
        
        // Layout setup
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        // Add components to grid
        grid.add(titleLabel, 0, 0, 2, 1);
        grid.add(customerIdLabel, 0, 1);
        grid.add(customerIdField, 1, 1);
        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);
        grid.add(loginButton, 1, 3);
        grid.add(messageLabel, 1, 4);
        
        // Set button action
        loginButton.setOnAction(e -> attemptLogin());
        
        // Create scene and show stage
        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    /**
     * Method to handle login attempt
     */
    private void attemptLogin() {
        String customerId = customerIdField.getText();
        String password = passwordField.getText();
        
        // For demonstration - will connect to controller later
        if (!customerId.isEmpty() && !password.isEmpty()) {
            messageLabel.setText("Login attempted for: " + customerId);
            messageLabel.setStyle("-fx-text-fill: green;");
        } else {
            messageLabel.setText("Please enter both customer ID and password");
            messageLabel.setStyle("-fx-text-fill: red;");
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}