/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part1;

import javax.swing.JOptionPane;

/**
 *
 * @author silol
 */
public class Part1 {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String cellNumber;

    // Register user
    public String registerUser() {
        firstName = JOptionPane.showInputDialog("Enter your first name:");
        lastName = JOptionPane.showInputDialog("Enter your last name:");
        username = JOptionPane.showInputDialog("Enter a username:");
        password = JOptionPane.showInputDialog("Enter a password:");
        cellNumber = JOptionPane.showInputDialog("Enter your cell number:");

        boolean userCheck = checkUserName();
        boolean passCheck = checkPasswordComplexity();
        boolean phoneCheck = checkCellPhoneNumber();

        if (!userCheck) {
            return "Username is not correctly formatted. Must contain '_' and be 5 characters or fewer.";
        }

        if (!passCheck) {
            return "Password is not correctly formatted. It must be at least 8 characters, contain a capital letter, number, and special character.";
        }

        if (!phoneCheck) {
            return "Cell number is not correctly formatted. It must start with +27 and be no more than 10 digits after that.";
        }

        return "User has been registered successfully!";
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        boolean length = password.length() >= 8;
        boolean capital = password.matches(".*[A-Z].*");
        boolean number = password.matches(".*\\d.*");
        boolean special = password.matches(".*[!@#$%^&*(),.?\":{}|<>].*");

        return length && capital && number && special;
    }

    public boolean checkCellPhoneNumber() {
        return cellNumber.startsWith("+27") && cellNumber.length() <= 13;
    }

    public boolean loginUser(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    public String returnLoginStatus(boolean isLoginSuccessful) {
        if (isLoginSuccessful) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again!";
        } else {
            return "Username or password is incorrect.";
        }
    }
  
    // MAIN METHOD TO RUN EVERYTHING
    public static void main(String[] args) {
        Part1 login = new Part1();
        JOptionPane.showMessageDialog(null, login.registerUser());

        String inputUsername = JOptionPane.showInputDialog("Login - Enter your username:");
        String inputPassword = JOptionPane.showInputDialog("Login - Enter your password:");

        boolean loginResult = login.loginUser(inputUsername, inputPassword);
        JOptionPane.showMessageDialog(null, login.returnLoginStatus(loginResult));
    
    
    }
}