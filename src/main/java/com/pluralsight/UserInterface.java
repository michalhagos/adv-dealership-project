package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    // the dealership object this User interface will interact with
    // loaded from the inventory.csv file when the app starts
    private Dealership dealership;


    // this method loads the dealership from the CSV file
    // called at the start of display() before the menu runs
    private void init() {
        // create the file manager so we can read the CSV
        DealershipFileManager fileManager = new DealershipFileManager();
        // load the dealership and store it in this class
        this.dealership = fileManager.getDealership();
    }


    // this is helper method that displays a list of vehicles. called by every search
    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        System.out.println();
        // loop through every vehicle in the list and print it
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
    // gets all vehicles from the dealership and displays them
// this is the first method I implement to test the file loading works
    public void processGetAllVehiclesRequest() {
        // get the full inventory list from the dealership
        ArrayList<Vehicle> allVehicles = dealership.getAllVehicles();
        // pass the list to the helper method to display it
        this.displayVehicles(allVehicles);
    }

    // This Method will ask user for price range and display matching vehicles

    public void processGetByPriceRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the minimum price
        System.out.print("Enter minimum price: ");
        double min = Double.parseDouble(scanner.nextLine());

        // ask the user for the maximum price
        System.out.print("Enter maximum price: ");
        double max = Double.parseDouble(scanner.nextLine());

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByPrice(min, max);
        this.displayVehicles(results);
    }

    // This Method will ask user for make and model and display matching vehicles

    public void processGetByMakeModelRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the make
        System.out.print("Enter make: ");
        String make = scanner.nextLine();

        // ask the user for the model
        System.out.print("Enter model: ");
        String model = scanner.nextLine();

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByMakeModel(make, model);
        this.displayVehicles(results);
    }


    // This Method will ask user for year range and display matching vehicles
    public void processGetByYearRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the minimum year
        System.out.print("Enter minimum year: ");
        int min = Integer.parseInt(scanner.nextLine());

        // ask the user for the maximum year
        System.out.print("Enter maximum year: ");
        int max = Integer.parseInt(scanner.nextLine());

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByYear(min, max);
        this.displayVehicles(results);
    }

    // This Method will ask user for color and display matching vehicles
    public void processGetByColorRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the color they want
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByColor(color);
        this.displayVehicles(results);
    }

    // This Method will ask user for mileage range and display matching vehicles

    public void processGetByMileageRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the minimum mileage
        System.out.print("Enter minimum mileage: ");
        int min = Integer.parseInt(scanner.nextLine());

        // ask the user for the maximum mileage
        System.out.print("Enter maximum mileage: ");
        int max = Integer.parseInt(scanner.nextLine());

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByMileage(min, max);
        this.displayVehicles(results);
    }

    // This Method  will ask user for vehicle type and display matching vehicles
    public void processGetByVehicleTypeRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the vehicle type they want
        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String type = scanner.nextLine();

        // get matching vehicles from the dealership and display them
        ArrayList<Vehicle> results = dealership.getVehiclesByType(type);
        this.displayVehicles(results);
    }

    // asks the user for all vehicle details
// creates a new vehicle and adds it to the dealership
// then saves the updated inventory to the inventory.csv file
    public void processAddVehicleRequest() {
        Scanner theScanner = new Scanner(System.in);

        // ask the user for each piece of vehicle information
        System.out.print("Enter VIN: ");
        int vin = Integer.parseInt(theScanner.nextLine());

        System.out.print("Enter year: ");
        int year = Integer.parseInt(theScanner.nextLine());

        System.out.print("Enter make: ");
        String make = theScanner.nextLine();

        System.out.print("Enter model: ");
        String model = theScanner.nextLine();

        System.out.print("Enter vehicle type (car, truck, SUV, van): ");
        String vehicleType = theScanner.nextLine();

        System.out.print("Enter color: ");
        String color = theScanner.nextLine();

        System.out.print("Enter odometer reading: ");
        int odometer = Integer.parseInt(theScanner.nextLine());

        System.out.print("Enter price: ");
        double price = Double.parseDouble(theScanner.nextLine());

        // create the new vehicle object from the user input
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // add the vehicle to the dealership inventory
        dealership.addVehicle(vehicle);

        // save the updated inventory back to the CSV file
        DealershipFileManager fileManager = new DealershipFileManager();
        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    // asks the user for a vin number
// finds that vehicle and removes it from the dealership
// then saves the updated inventory to the CSV file
    public void processRemoveVehicleRequest() {
        Scanner scanner = new Scanner(System.in);

        // ask the user for the vin of the vehicle to remove
        System.out.print("Enter VIN of vehicle to remove: ");
        int vin = Integer.parseInt(scanner.nextLine());

        // search through the inventory to find the vehicle with that vin
        Vehicle vehicleToRemove = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                // found the vehicle so store it
                vehicleToRemove = vehicle;
                break;
            }
        }

        // if we found the vehicle remove it and save the file
        if (vehicleToRemove != null) {
            dealership.removeVehicle(vehicleToRemove);

            // save the updated inventory back to the CSV file
            DealershipFileManager fileManager = new DealershipFileManager();
            fileManager.saveDealership(dealership);

            System.out.println("Vehicle removed successfully!");
        } else {
            // no vehicle with that vin was found
            System.out.println("No vehicle found with that VIN.");
        }
    }

    // this method handles the full sell or lease process
// asks the user for all required information
// creates the correct contract and saves it to the contracts.csv file

    public void processSellOrLeaseRequest() {
        Scanner scanner = new Scanner(System.in);

// ask the user for the VIN of the vehicle they want to buy or lease
        System.out.print("Enter the VIN of the vehicle: ");
        int vinNumber = Integer.parseInt(scanner.nextLine());

        // search through the inventory to find the vehicle with that VIN
        Vehicle selectedVehicle = null;
        for (Vehicle currentVehicle : dealership.getAllVehicles()) {
            if (currentVehicle.getVin() == vinNumber) {
                // found the vehicle so store it
                selectedVehicle = currentVehicle;
                break;
            }
        }

        // if no vehicle was found with that VIN tell the user and stop
        if (selectedVehicle == null) {
            System.out.println("No vehicle found with that VIN.");
            return;
        }

// ask the user for the customer information
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String customerEmail = scanner.nextLine();

// get today's date as a string for the contract and date format is YYYYMMDD
        String contractDate = java.time.LocalDate.now().toString().replace("-", "");



        // ask the user if they want to sell or lease the vehicle
        System.out.print("Is this a sale or a lease? (sale/lease): ");
        String contractType = scanner.nextLine().trim().toLowerCase();

// create a variable to hold the contract we will create
        Contract newContract = null;

        if (contractType.equals("sale")) {
            // ask if the customer wants to finance the purchase
            System.out.print("Does the customer want to finance? (yes/no): ");
            String financeAnswer = scanner.nextLine().trim().toLowerCase();
            boolean customerWantsToFinance = financeAnswer.equals("yes");

            // create a new SalesContract with all the collected information
            SalesContract newSalesContract = new SalesContract(
                    contractDate,
                    customerName,
                    customerEmail,
                    selectedVehicle,
                    customerWantsToFinance
            );

            // store the contract in the newContract variable
            newContract = newSalesContract;

            // show the customer a summary of their sale
            System.out.println("\n--- Sale Summary ---");
            System.out.println("Vehicle: " + selectedVehicle.getYear() + " " +
                    selectedVehicle.getMake() + " " +
                    selectedVehicle.getModel());
            System.out.printf("Vehicle Price: $%.2f%n", selectedVehicle.getPrice());
            System.out.printf("Total Price: $%.2f%n", newSalesContract.getTotalPrice());
            if (customerWantsToFinance) {
                System.out.printf("Monthly Payment: $%.2f%n", newSalesContract.getMonthlyPayment());
            } else {
                System.out.println("No financing selected");
            }
        }
        else if (contractType.equals("lease")) {
            // check if the vehicle is eligible for leasing
            // you cannot lease a vehicle over 3 years old
            int currentYear = java.time.LocalDate.now().getYear();
            int vehicleAge = currentYear - selectedVehicle.getYear();

            if (vehicleAge > 3) {
                System.out.println("Sorry this vehicle is too old to lease.");
                System.out.println("You can only lease vehicles that are 3 years old or newer.");
                return;
            }

            // create a new LeaseContract with all the collected information
            LeaseContract newLeaseContract = new LeaseContract(
                    contractDate,
                    customerName,
                    customerEmail,
                    selectedVehicle
            );

            // store the contract in the newContract variable
            newContract = newLeaseContract;

            // show the customer a summary of their lease
            System.out.println("\n--- Lease Summary ---");
            System.out.println("Vehicle: " + selectedVehicle.getYear() + " " +
                    selectedVehicle.getMake() + " " +
                    selectedVehicle.getModel());
            System.out.printf("Vehicle Price: $%.2f%n", selectedVehicle.getPrice());
            System.out.printf("Expected Ending Value: $%.2f%n", newLeaseContract.getExpectedEndingValue());
            System.out.printf("Lease Fee: $%.2f%n", newLeaseContract.getLeaseFee());
            System.out.printf("Total Price: $%.2f%n", newLeaseContract.getTotalPrice());
            System.out.printf("Monthly Payment: $%.2f%n", newLeaseContract.getMonthlyPayment());
        }




    }



    // the display method starts the application and runs the menu loop
// called from Program main method to kick everything off
    public void display() {
        // load the dealership from the CSV file before showing the menu
        this.init();

        // create a scanner to read the user's menu choices
        Scanner theScanner = new Scanner(System.in);

        // this controls whether the menu keeps running
        boolean menuRunning = true;

        while (menuRunning) {
            // show the menu options to the user
            System.out.println("\n=== Car Dealership Menu ===");
            System.out.println("1 - Find vehicles by price");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List all vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("10 - Sell or lease a vehicle");
            System.out.println("99 - Quit");
            System.out.print("Enter option: ");

            // read the user's choice safely
            // if they type something that is not a number we handle it gracefully
            int option;
            if (theScanner.hasNextInt()) {
                // user typed a valid number so we take it
                option = theScanner.nextInt();
                // eat the leftover newline so the next scanner read works correctly
                theScanner.nextLine();
            } else {
                // user typed something invalid so we discard it
                theScanner.nextLine();
                // set option to -1 so the switch hits the default case
                option = -1;
            }

            // call the correct method based on what the user chose
            switch (option) {
                case 1:
                    this.processGetByPriceRequest();
                    break;
                case 2:
                    this.processGetByMakeModelRequest();
                    break;
                case 3:
                    this.processGetByYearRequest();
                    break;
                case 4:
                    this.processGetByColorRequest();
                    break;
                case 5:
                    this.processGetByMileageRequest();
                    break;
                case 6:
                    this.processGetByVehicleTypeRequest();
                    break;
                case 7:
                    this.processGetAllVehiclesRequest();
                    break;
                case 8:
                    this.processAddVehicleRequest();
                    break;
                case 9:
                    this.processRemoveVehicleRequest();
                    break;
                case 10:
                    this.processSellOrLeaseRequest();
                    break;
                case 99:
                    // stop the menu loop and say goodbye
                    menuRunning = false;
                    System.out.println("Have a great day!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }






}