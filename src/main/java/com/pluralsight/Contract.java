package com.pluralsight;

public abstract class Contract {
    // creating the fields for the abstract contract class
    // the date the contract was created
    private String date;
    // the name of the customer
    private String customerName;
    // the email of the customer
    private String customerEmail;
    // the vehicle that is being sold or leased
    private Vehicle vehicleSold;

    // A constructor sets all shared fields. it will be called by child classes using super()
    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    // returns the date the contract was created
    public String getDate() {
        return date;
    }

    // updates the date the contract was created
    public void setDate(String date) {
        this.date = date;
    }

    // returns the name of the customer
    public String getCustomerName() {
        return customerName;
    }

    // updates the name of the customer
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    // returns the email of the customer
    public String getCustomerEmail() {
        return customerEmail;
    }

    // updates the email of the customer
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    // returns the vehicle that is being sold or leased
    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    // updates the vehicle that is being sold or leased
    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }

    // The following abstract methods that child classes MUST implement
    // SalesContract and LeaseContract will each calculate this differently


// calculates the total price based on the type of contract
    public abstract double getTotalPrice();

// calculates the monthly payment based on the type of contract
    public abstract double getMonthlyPayment();




}
