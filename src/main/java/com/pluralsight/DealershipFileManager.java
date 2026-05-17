package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {

    // the path to the inventory CSV file that holds the dealership and vehicle data

    private final String FILE_PATH = "src/main/resources/inventory.csv";

    // reads the inventory CSV file and builds a fully loaded Dealership object
// returns the dealership with all its vehicles populated from the file
    public Dealership getDealership() {

        // the dealership object we will build and return
        Dealership theDealership = null;

        try {
            // open the CSV file for reading line by line
            BufferedReader inventoryReader = new BufferedReader(new FileReader(FILE_PATH));
            // read the first line which contains the dealership info
// format is: name|address|phone
            String dealershipInfo = inventoryReader.readLine();

            // split the first line by pipe to get the individual parts
            String[] dealershipParts = dealershipInfo.split("\\|");

            // extract each part of the dealership info
            String name = dealershipParts[0];
            String address = dealershipParts[1];
            String phone = dealershipParts[2];

// create the dealership object using the info from the first line
            theDealership = new Dealership(name, address, phone);
// read every remaining line which represents one vehicle each
// keep reading until there are no more lines that is the use of while loop here
            String vehicleInfo;
            while ((vehicleInfo = inventoryReader.readLine()) != null) {
// splitting that one vehicle line by |
                String[] vehicleParts = vehicleInfo.split("\\|");

                // parse each part into the right type
                int vin          = Integer.parseInt(vehicleParts[0]);
                int year         = Integer.parseInt(vehicleParts[1]);
                String make      = vehicleParts[2];
                String model     = vehicleParts[3];
                String type      = vehicleParts[4];
                String color     = vehicleParts[5];
                int odometer     = Integer.parseInt(vehicleParts[6]);
                double price     = Double.parseDouble(vehicleParts[7]);

                // create the Vehicle object and add it to the dealership
                Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
                theDealership.addVehicle(vehicle);

            }
            inventoryReader.close();



        } catch (Exception e) {
            System.out.println("Error reading dealership file: " + e.getMessage());
        }

        return theDealership;




    }
    // saves the dealership and its full inventory back to the CSV file
// overwrites the existing file with the most current data
    public void saveDealership(Dealership dealership) {
        try {
            // open the file for writing - this overwrites the existing file
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(FILE_PATH));

            // write the dealership info as the first line
            // format is: name|address|phone
            fileWriter.write(dealership.getName() + "|" +
                    dealership.getAddress() + "|" +
                    dealership.getPhone());
            fileWriter.newLine();

            // write one line for each vehicle using its toString method
            // toString already formats it as pipe delimited
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                fileWriter.write(vehicle.toString());
                fileWriter.newLine();
            }

            // closing the file when done writing
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("Error saving dealership file: " + e.getMessage());
        }
    }






}