package com.dealership.ui;

import com.dealership.data.DealershipFileManager;
import com.dealership.model.Dealership;
import com.dealership.model.Vehicle;

import java.util.List;
import java.util.Scanner;

/**
 * Handles user interaction for the dealership application
 */
public class UserInterface {
    private Dealership dealership;
    private Scanner scanner;
    private DealershipFileManager fileManager;

    /**
     * Constructor for the UserInterface class
     */
    public UserInterface() {
        scanner = new Scanner(System.in);
        fileManager = new DealershipFileManager();
    }

    /**
     * Initializes the dealership by loading data from the file
     */
    private void init() {
        dealership = fileManager.getDealership();
        if (dealership == null) {
            System.out.println("Error: Could not load dealership data.");
            System.exit(1);
        }
    }

    /**
     * Displays the main menu and handles user input
     */
    public void display() {
        init();

        int choice = 0;
        while (choice != 99) {
            displayMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice) {
                    case 1:
                        processGetByPriceRequest();
                        break;
                    case 2:
                        processGetByMakeModelRequest();
                        break;
                    case 3:
                        processGetByYearRequest();
                        break;
                    case 4:
                        processGetByColorRequest();
                        break;
                    case 5:
                        processGetByMileageRequest();
                        break;
                    case 6:
                        processGetByVehicleTypeRequest();
                        break;
                    case 7:
                        processAllVehiclesRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 99:
                        System.out.println("Thank you for using the Dealership Application. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

            // If not exiting, pause before showing menu again
            if (choice != 99) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    /**
     * Displays the main menu options
     */
    private void displayMenu() {
        System.out.println("\n" + dealership.getName() + " - Dealership Management System");
        System.out.println("------------------------------------------");
        System.out.println("1 - Find vehicles within a price range");
        System.out.println("2 - Find vehicles by make/model");
        System.out.println("3 - Find vehicles by year range");
        System.out.println("4 - Find vehicles by color");
        System.out.println("5 - Find vehicles by mileage range");
        System.out.println("6 - Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7 - List ALL vehicles");
        System.out.println("8 - Add a vehicle");
        System.out.println("9 - Remove a vehicle");
        System.out.println("99 - Quit");
        System.out.print("\nEnter your choice: ");
    }

    /**
     * Displays a list of vehicles
     *
     * @param vehicles List of vehicles to display
     */
    private void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found matching the criteria.");
            return;
        }

        System.out.println("\nVehicles Found: " + vehicles.size());
        System.out.println("------------------------------------------");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    /**
     * Processes the request to list all vehicles
     */
    private void processAllVehiclesRequest() {
        System.out.println("\nAll Vehicles in Inventory:");
        displayVehicles(dealership.getAllVehicles());
    }

    /**
     * Processes the request to find vehicles within a price range
     */
    private void processGetByPriceRequest() {
        System.out.println("\nFind Vehicles by Price Range:");

        double min, max;
        try {
            System.out.print("Enter minimum price: $");
            min = Double.parseDouble(scanner.nextLine().trim());

            System.out.print("Enter maximum price: $");
            max = Double.parseDouble(scanner.nextLine().trim());

            if (min < 0 || max < 0 || min > max) {
                System.out.println("Invalid price range. Please try again.");
                return;
            }

            List<Vehicle> vehicles = dealership.getVehiclesByPrice(min, max);
            displayVehicles(vehicles);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }

    /**
     * Processes the request to find vehicles by make and model
     */
    private void processGetByMakeModelRequest() {
        System.out.println("\nFind Vehicles by Make and/or Model:");

        System.out.print("Enter make (or leave blank for any make): ");
        String make = scanner.nextLine().trim();

        System.out.print("Enter model (or leave blank for any model): ");
        String model = scanner.nextLine().trim();

        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);
        displayVehicles(vehicles);
    }

    /**
     * Processes the request to find vehicles within a year range
     */
    private void processGetByYearRequest() {
        System.out.println("\nFind Vehicles by Year Range:");

        int min, max;
        try {
            System.out.print("Enter minimum year: ");
            min = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter maximum year: ");
            max = Integer.parseInt(scanner.nextLine().trim());

            if (min < 1900 || max < 1900 || min > max) {
                System.out.println("Invalid year range. Please try again.");
                return;
            }

            List<Vehicle> vehicles = dealership.getVehiclesByYear(min, max);
            displayVehicles(vehicles);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid years.");
        }
    }

    /**
     * Processes the request to find vehicles by color
     */
    private void processGetByColorRequest() {
        System.out.println("\nFind Vehicles by Color:");

        System.out.print("Enter color: ");
        String color = scanner.nextLine().trim();

        if (color.isEmpty()) {
            System.out.println("Color cannot be empty. Please try again.");
            return;
        }

        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);
        displayVehicles(vehicles);
    }

    /**
     * Processes the request to find vehicles within a mileage range
     */
    private void processGetByMileageRequest() {
        System.out.println("\nFind Vehicles by Mileage Range:");

        int min, max;
        try {
            System.out.print("Enter minimum mileage: ");
            min = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter maximum mileage: ");
            max = Integer.parseInt(scanner.nextLine().trim());

            if (min < 0 || max < 0 || min > max) {
                System.out.println("Invalid mileage range. Please try again.");
                return;
            }

            List<Vehicle> vehicles = dealership.getVehiclesByMileage(min, max);
            displayVehicles(vehicles);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid mileage values.");
        }
    }

    /**
     * Processes the request to find vehicles by type
     */
    private void processGetByVehicleTypeRequest() {
        System.out.println("\nFind Vehicles by Type:");
        System.out.println("Available types: car, truck, SUV, van");

        System.out.print("Enter vehicle type: ");
        String type = scanner.nextLine().trim().toLowerCase();

        if (type.isEmpty()) {
            System.out.println("Vehicle type cannot be empty. Please try again.");
            return;
        }

        List<Vehicle> vehicles = dealership.getVehiclesByType(type);
        displayVehicles(vehicles);
    }

    /**
     * Processes the request to add a vehicle
     */
    private void processAddVehicleRequest() {
        System.out.println("\nAdd a New Vehicle:");

        try {
            System.out.print("Enter VIN: ");
            int vin = Integer.parseInt(scanner.nextLine().trim());

            // Check if VIN already exists
            for (Vehicle v : dealership.getAllVehicles()) {
                if (v.getVin() == vin) {
                    System.out.println("Error: Vehicle with this VIN already exists.");
                    return;
                }
            }

            System.out.print("Enter year: ");
            int year = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter make: ");
            String make = scanner.nextLine().trim();

            System.out.print("Enter model: ");
            String model = scanner.nextLine().trim();

            System.out.print("Enter vehicle type (car, truck, SUV, van): ");
            String vehicleType = scanner.nextLine().trim();

            System.out.print("Enter color: ");
            String color = scanner.nextLine().trim();

            System.out.print("Enter odometer reading: ");
            int odometer = Integer.parseInt(scanner.nextLine().trim());

            System.out.print("Enter price: $");
            double price = Double.parseDouble(scanner.nextLine().trim());

            // Validate inputs
            if (year < 1900 || odometer < 0 || price < 0 ||
                    make.isEmpty() || model.isEmpty() || vehicleType.isEmpty() || color.isEmpty()) {
                System.out.println("Error: Invalid input values. Vehicle not added.");
                return;
            }

            // Create and add the vehicle
            Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
            dealership.addVehicle(vehicle);

            // Save the updated dealership to file
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid numeric input. Vehicle not added.");
        }
    }

    /**
     * Processes the request to remove a vehicle
     */
    private void processRemoveVehicleRequest() {
        System.out.println("\nRemove a Vehicle:");

        try {
            System.out.print("Enter the VIN of the vehicle to remove: ");
            int vin = Integer.parseInt(scanner.nextLine().trim());

            Vehicle removedVehicle = dealership.removeVehicle(vin);
            if (removedVehicle != null) {
                // Save the updated dealership to file
                fileManager.saveDealership(dealership);
                System.out.println("Vehicle removed successfully:");
                System.out.println(removedVehicle.toString());
            } else {
                System.out.println("Error: No vehicle found with VIN " + vin);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid VIN format. Please enter a valid number.");
        }
    }
}
