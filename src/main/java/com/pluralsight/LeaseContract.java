package com.pluralsight;

public class LeaseContract extends Contract {

    // expected ending value is 50% of the original vehicle price
    private double expectedEndingValue;
    // lease fee is 7% of the original vehicle price
    private double leaseFee;

    // constructor calls the Contract parent constructor using super
// then calculates and sets all the lease specific fields automatically
    public LeaseContract(String date, String customerName, String customerEmail,
                         Vehicle vehicleSold) {
        // call the parent Contract constructor for all shared fields
        super(date, customerName, customerEmail, vehicleSold);

        // expected ending value is always 50% of the original price
        this.expectedEndingValue = vehicleSold.getPrice() * 0.50;

        // lease fee is always 7% of the original price
        this.leaseFee = vehicleSold.getPrice() * 0.07;
    }

    // returns the expected ending value of the vehicle
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    // updates the expected ending value of the vehicle
    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    // returns the lease fee
    public double getLeaseFee() {
        return leaseFee;
    }

    // updates the lease fee
    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }





}
