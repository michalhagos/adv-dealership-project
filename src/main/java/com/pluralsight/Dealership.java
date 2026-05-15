package com.pluralsight;

import java.util.ArrayList;

public class Dealership {
    // adding private fields to the dealership class
    // the name of the dealership
    private String name;
    // the address of the dealership
    private String address;
    // the phone number of the dealership
    private String phone;
    // the list of all vehicles in the dealership inventory
    private ArrayList<Vehicle> inventory;

    // added a constructor that sets the dealership info and initializes the empty inventory list
// our inventory must be instantiated here so it is ready to hold vehicles
    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        // initialize the inventory list so it is ready to hold vehicles
        this.inventory = new ArrayList<>();
    }

    // added setters and getters
    // returns the name of the dealership
    public String getName() {
        return name;
    }

    // updates the name of the dealership
    public void setName(String name) {
        this.name = name;
    }

    // returns the address of the dealership
    public String getAddress() {
        return address;
    }

    // updates the address of the dealership
    public void setAddress(String address) {
        this.address = address;
    }

    // returns the phone number of the dealership
    public String getPhone() {
        return phone;
    }

    // updates the phone number of the dealership
    public void setPhone(String phone) {
        this.phone = phone;
    }


    // returns the full inventory list of all vehicles
    public ArrayList<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    // adds a new vehicle to the dealership inventory
    public void addVehicle(Vehicle vehicle) {
        this.inventory.add(vehicle);
    }

    // here are getters that need to return an array list


    // returns all vehicles within the given price range
// loops through inventory and adds matches to the results list
    public ArrayList<Vehicle> getVehiclesByPrice(double min, double max) {
        // this list will hold all vehicles that match the price range
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if the vehicle price is between min and max add it to results
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // returns all vehicles matching the given make and model
// used ignore case so that comparison is not case-sensitive so Ford and ford both work
    public ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        // this list will hold all vehicles that match the make and model
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if both make and model match add it to results
            if (vehicle.getMake().equalsIgnoreCase(make) &&
                    vehicle.getModel().equalsIgnoreCase(model)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // returns all vehicles within the given year range
// loops through inventory and adds matches to the results list
    public ArrayList<Vehicle> getVehiclesByYear(int min, int max) {
        // this list will hold all vehicles that match the year range
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if the vehicle year is between min and max add it to results
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // returns all vehicles matching the given color

    public ArrayList<Vehicle> getVehiclesByColor(String color) {
        // this list will hold all vehicles that match the color
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if the color matches add it to results
            if (vehicle.getColor().equalsIgnoreCase(color)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // returns all vehicles within the given mileage range
// loops through inventory and adds matches to the results list
    public ArrayList<Vehicle> getVehiclesByMileage(int min, int max) {
        // this list will hold all vehicles that match the mileage range
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if the odometer reading is between min and max add it to results
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // returns all vehicles matching the given vehicle type

    public ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        // this list will hold all vehicles that match the type
        ArrayList<Vehicle> results = new ArrayList<>();

        // check every vehicle in the inventory
        for (Vehicle vehicle : this.inventory) {
            // if the vehicle type matches add it to results
            if (vehicle.getVehicleType().equalsIgnoreCase(vehicleType)) {
                results.add(vehicle);
            }
        }

        return results;
    }

    // this method removes a vehicle from the dealership inventory by matching the VIN number
// loops through inventory and removes the vehicle with the matching vin
    public void removeVehicle(Vehicle vehicle) {
        // remove the vehicle from the inventory list
        this.inventory.remove(vehicle);
    }











}