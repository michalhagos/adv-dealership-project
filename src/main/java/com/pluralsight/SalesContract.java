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

}
