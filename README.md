# Advanced Car Dealership System

## What is this project?
This is a Java program that runs in the console (terminal). It simulates a car
dealership management system where a sales manager can search for cars, add new
cars, remove cars, sell cars, and lease cars. All the data is saved in files so
nothing is lost when you close the program.

## How to run it
1. Clone the repository to your computer
2. Open the project in IntelliJ
3. Find the file called Program.java
4. Click the green play button to run it
5. The menu will appear and you can start using the app

## How to use the menu
When you run the program you will see a menu like this:

=== Car Dealership Menu ===
1 - Find vehicles by price
2 - Find vehicles by make/model
3 - Find vehicles by year range
4 - Find vehicles by color
5 - Find vehicles by mileage
6 - Find vehicles by type
7 - List all vehicles
8 - Add a vehicle
9 - Remove a vehicle
10 - Sell or lease a vehicle
99 - Quit

Just type the number and hit Enter to choose an option.

## What can it do?
- Search for cars by price, make, model, year, color, mileage, or type
- See all cars in the inventory
- Add a new car to the inventory
- Remove a car from the inventory
- Sell a car to a customer with or without financing
- Lease a car to a customer with automatic monthly payment calculation
- Save all sales and leases to a contracts file automatically

## How selling works
When you sell a car the program automatically calculates:
- 5% sales tax on the vehicle price
- A flat $100 recording fee
- A processing fee of $295 for cars under $10,000 or $495 for cars $10,000 and over
- If the customer wants to finance the program calculates a monthly payment
- Cars $10,000 or more: 4.25% interest rate for 48 months
- Cars under $10,000: 5.25% interest rate for 24 months

## How leasing works
When you lease a car the program automatically calculates:
- The expected ending value which is 50% of the original price
- A lease fee which is 7% of the original price
- A monthly payment at 4.0% interest for 36 months
- Note: you can only lease cars that are 3 years old or newer

## Where is the data saved?
All the cars in the inventory are saved in:
src/main/resources/inventory.csv

All the sales and leases are saved in:
src/main/resources/contracts.csv

These are simple text files that you can open and read at any time.

## Classes in this project
This project is built using Object Oriented Programming. Here is what each class does:

- Program — starts the application
- UserInterface — shows the menu and talks to the user
- Dealership — keeps track of all the cars in the inventory
- Vehicle — represents one car with all its details
- DealershipFileManager — reads and writes the inventory file
- Contract — the base class for all contracts
- SalesContract — handles all the details of selling a car
- LeaseContract — handles all the details of leasing a car
- ContractFileManager — saves contracts to the contracts file

## Technologies used
- Java
- Maven
- IntelliJ IDEA

