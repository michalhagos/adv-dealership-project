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

    // this method calculates the monthly payment if the customer chose to finance

    @Override
    public double getMonthlyPayment() {
        // if customer chose not to finance return 0
        if (!isFinanced) {
            return 0.00;
        }

        // get the total price to finance
        double totalPrice = getTotalPrice();

        // set the interest rate and number of months based on price
        double interestRate;
        int months;

        if (totalPrice >= 10000) {
            // loans $10,000 or more are at 4.25% for 48 months
            interestRate = 0.0425 / 12;
            months = 48;
        } else {
            // loans under $10,000 are at 5.25% for 24 months
            interestRate = 0.0525 / 12;
            months = 24;
        }

        // calculate monthly payment using standard loan formula
        // M = P * (r(1+r)^n) / ((1+r)^n - 1)
        // P = principal, r = monthly rate, n = number of months
        return totalPrice * (interestRate * Math.pow(1 + interestRate, months)) /
                (Math.pow(1 + interestRate, months) - 1);
    }














}
