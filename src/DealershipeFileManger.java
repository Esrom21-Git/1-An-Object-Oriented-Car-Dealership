
package com.dealership.data;

import Home.Dealership;
import com.dealership.model.Dealership;
import com.dealership.model.Vehicle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Manages reading from and writing to the dealership file
 */
public class DealershipFileManager {
    private static final String DELIMITER = "\\|";
    private static final String FILE_PATH = "src/main/resources/inventory.csv";

    /**
     * Reads the dealership file and creates a Dealership object
     *
     * @return A Dealership object populated with data from the file
     */
    public Dealership getDealership() {
        Dealership dealership = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // First line contains dealership info
            String dealershipLine = reader.readLine();
            if (dealershipLine != null) {
                String[] dealershipData = dealershipLine.split(DELIMITER);
                if (dealershipData.length >= 3) {
                    String name = dealershipData[0].trim();
                    String address = dealershipData[1].trim();
                    String phone = dealershipData[2].trim();
                    dealership = new Dealership(name, address, phone);

                    // Read vehicle data
                    String vehicleLine;
                    while ((vehicleLine = reader.readLine()) != null) {
                        try {
                            String[] vehicleData = vehicleLine.split(DELIMITER);
                            if (vehicleData.length >= 8) {
                                int vin = Integer.parseInt(vehicleData[0].trim());
                                int year = Integer.parseInt(vehicleData[1].trim());
                                String make = vehicleData[2].trim();
                                String model = vehicleData[3].trim();
                                String type = vehicleData[4].trim();
                                String color = vehicleData[5].trim();
                                int odometer = Integer.parseInt(vehicleData[6].trim());
                                double price = Double.parseDouble(vehicleData[7].trim());

                                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                                dealership.addVehicle(vehicle);
                            }
                        } catch (NumberFormatException e) {
                            System.err.println("Error parsing vehicle data: " + e.getMessage());
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading dealership file: " + e.getMessage());
        }

        return dealership;
    }

    /**
     * Saves the Dealership object to the dealership file
     *
     * @param dealership The Dealership object to save
     */
    public void saveDealership(Dealership dealership) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            // Write dealership info
            writer.write(String.format("%s|%s|%s",
                    dealership.getName(), dealership.getAddress(), dealership.getPhone()));
            writer.newLine();

            // Write vehicle info
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f",
                        vehicle.getVin(), vehicle.getYear(), vehicle.getMake(), vehicle.getModel(),
                        vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice()));
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to dealership file: " + e.getMessage());
        }
    }
}