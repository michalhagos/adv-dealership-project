package com.pluralsight;

public class SalesContract extends Contract  {

    // the sales tax is always 5% of the vehicle price
    private double salesTaxAmount;
    // recording fee is always a flat $100
    private double recordingFee;
    // processing fee is $295 for vehicles under $10,000 and $495 for all others
    private double processingFee;
    // whether the customer wants to finance the purchase
    private boolean isFinanced;

    // constructor calls the Contract parent constructor using super
// then calculates and sets all the sales specific fields automatically
    public SalesContract(String date, String customerName, String customerEmail,
                         Vehicle vehicleSold, boolean isFinanced) {
        // call the parent Contract constructor for all shared fields
        super(date, customerName, customerEmail, vehicleSold);

        // sales tax is always 5% of the vehicle price
        this.salesTaxAmount = vehicleSold.getPrice() * 0.05;

        // recording fee is always a flat $100
        this.recordingFee = 100.00;

        // processing fee depends on the vehicle price
        // $295 for vehicles under $10,000 and $495 for all others
        if (vehicleSold.getPrice() < 10000) {
            this.processingFee = 295.00;
        } else {
            this.processingFee = 495.00;
        }

        // store whether the customer wants to finance
        this.isFinanced = isFinanced;
    }

    // returns the sales tax amount
    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    // updates the sales tax amount
    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    // returns the recording fee
    public double getRecordingFee() {
        return recordingFee;
    }

    // updates the recording fee
    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    // returns the processing fee
    public double getProcessingFee() {
        return processingFee;
    }

    // updates the processing fee
    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    // returns whether the customer wants to finance
    public boolean isFinanced() {
        return isFinanced;
    }

    // updates whether the customer wants to finance
    public void setFinanced(boolean isFinanced) {
        this.isFinanced = isFinanced;
    }

    // calculates the total price of the sale
// total = vehicle price + sales tax + recording fee + processing fee
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() +
                salesTaxAmount +
                recordingFee +
                processingFee;
    }
















}
