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
// this part will be the same for sale and lease contracts
            String vehicleInfo = soldVehicle.getVin() + "|" +
                    soldVehicle.getYear() + "|" +
                    soldVehicle.getMake() + "|" +
                    soldVehicle.getModel() + "|" +
                    soldVehicle.getVehicleType() + "|" +
                    soldVehicle.getColor() + "|" +
                    soldVehicle.getOdometer() + "|" +
                    soldVehicle.getPrice();

// build the contract portion of the contract.csv line. this part is the same for both sale and lease contracts
            String contractInfo = contract.getDate() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|";


            // use instanceof to check what type of contract we have
            if (contract instanceof SalesContract) {
                // cast the contract to SalesContract so we can access sale specific fields
                SalesContract salesContract = (SalesContract) contract;

                // write the full sale contract line to the file
                writer.write("SALE|" +
                        contractInfo +
                        vehicleInfo + "|" +
                        salesContract.getSalesTaxAmount() + "|" +
                        salesContract.getRecordingFee() + "|" +
                        salesContract.getProcessingFee() + "|" +
                        salesContract.getTotalPrice() + "|" +
                        (salesContract.isFinanced() ? "YES" : "NO") + "|" +
                        salesContract.getMonthlyPayment());
                writer.newLine();

            } else if (contract instanceof LeaseContract) {
                // cast the contract to LeaseContract so we can access lease specific fields
                LeaseContract leaseContract = (LeaseContract) contract;

                // write the full lease contract line to the file
                writer.write("LEASE|" +
                        contractInfo +
                        vehicleInfo + "|" +
                        leaseContract.getExpectedEndingValue() + "|" +
                        leaseContract.getLeaseFee() + "|" +
                        leaseContract.getTotalPrice() + "|" +
                        leaseContract.getMonthlyPayment());
                writer.newLine();
            }

            // close the file writer when done writing
            writer.close();



        } catch (Exception e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }




}
