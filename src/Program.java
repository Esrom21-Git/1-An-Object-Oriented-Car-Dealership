package com.dealership;

import com.dealership.ui.UserInterface;

/**
 * Main class for the dealership application
 */
public class Program {
    /**
     * Entry point for the application
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        System.out.println("Starting Dealership Management System...");

        UserInterface ui = new UserInterface();
        ui.display();
    }
}
