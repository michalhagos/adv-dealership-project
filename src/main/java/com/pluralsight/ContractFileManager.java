package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractFileManager {

    // this is a csv file that holds all contracts.
    private final String FILE_PATH = "src/main/resources/contracts.csv";

    // this method saves a contract to the contracts.csv file by appending to it

    public void saveContract(Contract contract) {
        try {
            // open the file for writing and true means we append to the file instead of overwriting it
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true));

            // get the vehicle from the contract so we can access its details
            Vehicle soldVehicle = contract.getVehicleSold();

// build the vehicle portion of the Contracts.csv line

            String vehicleInfo = soldVehicle.getVin() + "|" +
                    soldVehicle.getYear() + "|" +
                    soldVehicle.getMake() + "|" +
                    soldVehicle.getModel() + "|" +
                    soldVehicle.getVehicleType() + "|" +
                    soldVehicle.getColor() + "|" +
                    soldVehicle.getOdometer() + "|" +
                    soldVehicle.getPrice();











        } catch (Exception e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }









}
