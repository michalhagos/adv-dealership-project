package com.pluralsight;

public class Vehicle {

    // creating the fields I need inside the vehicle class
    // unique identifier for the vehicle the VIN number
    private int vin;
    // the year the vehicle was manufactured
    private int year;
    // the make of the vehicle - Ford, Honda, Toyota etc
    private String make;
    // the model of the vehicle example Explorer, Civic
    private String model;
    // the type of vehicle - car, truck, SUV, van
    private String vehicleType;
    // the color of the vehicle
    private String color;
    // how many miles the vehicle has been driven
    private int odometer;
    // the price of the vehicle
    private double price;

    // created a public constructor that sets all fields when a new vehicle is created
    public Vehicle(int vin, int year, String make, String model,
                   String vehicleType, String color, int odometer, double price) {
        this.vin = vin;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }
    // using getters to access my private fields
    // this getter returns the vehicle identification number
    public int getVin() {
        return vin;
    }

    // this getter returns the year the vehicle was manufactured
    public int getYear() {
        return year;
    }

    // this getter returns the make of the vehicle
    public String getMake() {
        return make;
    }

    // this getter returns the model of the vehicle
    public String getModel() {
        return model;
    }

    // this getter returns the type of the vehicle
    public String getVehicleType() {
        return vehicleType;
    }

    // this getter returns the color of the vehicle
    public String getColor() {
        return color;
    }

    // this getter returns how many miles the vehicle has been driven
    public int getOdometer() {
        return odometer;
    }

    // this getter returns the selling price of the vehicle
    public double getPrice() {
        return price;
    }
    // Creating setters to update my vehicle class
    // updates the vehicle identification number
    public void setVin(int vin) {
        this.vin = vin;
    }

    // updates the year the vehicle was manufactured
    public void setYear(int year) {
        this.year = year;
    }

    // updates the make of the vehicle
    public void setMake(String make) {
        this.make = make;
    }

    // updates the model of the vehicle
    public void setModel(String model) {
        this.model = model;
    }

    // updates the type of the vehicle
    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    // updates the color of the vehicle
    public void setColor(String color) {
        this.color = color;
    }

    // updates how many miles the vehicle has been driven
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // updates the selling price of the vehicle
    public void setPrice(double price) {
        this.price = price;
    }



    // the to string Build in method formats the vehicle as a pipe delimited string
// example: 10112|1993|Ford|Explorer|SUV|Red|525123|995.00
    @Override
    public String toString() {
        return vin + "|" + year + "|" + make + "|" + model + "|" +
                vehicleType + "|" + color + "|" + odometer + "|" + price;
    }








}