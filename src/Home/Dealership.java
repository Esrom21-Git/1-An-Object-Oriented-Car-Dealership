package com.dealership.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a dealership with its information and inventory
 */
public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    /**
     * Constructor for the Dealership class
     *
     * @param name    Name of the dealership
     * @param address Address of the dealership
     * @param phone   Phone number of the dealership
     */
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Adds a vehicle to the inventory
     *
     * @param vehicle Vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    /**
     * Removes a vehicle from the inventory by VIN
     *
     * @param vin VIN of the vehicle to remove
     * @return The removed vehicle, or null if not found
     */
    public Vehicle removeVehicle(int vin) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getVin() == vin) {
                return inventory.remove(i);
            }
        }
        return null;
    }

    /**
     * Returns all vehicles in the inventory
     *
     * @return List of all vehicles
     */
    public List<Vehicle> getAllVehicles() {
        return new ArrayList<>(inventory);
    }

    /**
     * Returns vehicles within a specified price range
     *
     * @param min Minimum price
     * @param max Maximum price
     * @return List of vehicles in the price range
     */
    public List<Vehicle> getVehiclesByPrice(double min, double max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            double price = vehicle.getPrice();
            if (price >= min && price <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * Returns vehicles of the specified make and model
     *
     * @param make  Make of the vehicle
     * @param model Model of the vehicle
     * @return List of vehicles with matching make and model
     */
    public List<Vehicle> getVehiclesByMakeModel(String make, String model) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if ((make == null || make.isEmpty() || vehicle.getMake().equalsIgnoreCase(make)) &&
                    (model == null || model.isEmpty() || vehicle.getModel().equalsIgnoreCase(model))) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * Returns vehicles within a specified year range
     *
     * @param min Minimum year
     * @param max Maximum year
     * @return List of vehicles in the year range
     */
    public List<Vehicle> getVehiclesByYear(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            int year = vehicle.getYear();
            if (year >= min && year <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * Returns vehicles of the specified color
     *
     * @param color Color of the vehicle
     * @return List of vehicles with matching color
     */
    public List<Vehicle> getVehiclesByColor(String color) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * Returns vehicles within a specified mileage range
     *
     * @param min Minimum mileage
     * @param max Maximum mileage
     * @return List of vehicles in the mileage range
     */
    public List<Vehicle> getVehiclesByMileage(int min, int max) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            int mileage = vehicle.getOdometer();
            if (mileage >= min && mileage <= max) {
                result.add(vehicle);
            }
        }
        return result;
    }

    /**
     * Returns vehicles of the specified type
     *
     * @param type Type of the vehicle (car, truck, SUV, van)
     * @return List of vehicles with matching type
     */
    public List<Vehicle> getVehiclesByType(String type) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equalsIgnoreCase(type)) {
                result.add(vehicle);
            }
        }
        return result;
    }
}
