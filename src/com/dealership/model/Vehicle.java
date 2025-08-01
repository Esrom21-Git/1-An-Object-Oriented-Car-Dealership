package com.dealership.model;

/**
 * Represents a vehicle in the dealership inventory
 */
public class Vehicle {
    private int vin;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private int odometer;
    private double price;

    /**
     * Constructor for the Vehicle class
     *
     * @param vin         Vehicle Identification Number
     * @param year        Year the vehicle was manufactured
     * @param make        Make of the vehicle
     * @param model       Model of the vehicle
     * @param vehicleType Type of vehicle (car, truck, SUV, van)
     * @param color       Color of the vehicle
     * @param odometer    Current odometer reading
     * @param price       Price of the vehicle
     */
    public Vehicle(int vin, int year, String make, String model, String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    // Getters and Setters
    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns a string representation of the vehicle
     *
     * @return String representation of the vehicle
     */
    @Override
    public String toString() {
        return String.format("VIN: %d | %d %s %s | Type: %s | Color: %s | Odometer: %d | Price: $%.2f",
                vin, year, make, model, vehicleType, color, odometer, price);
    }
}
