# Car Dealership Management System

This project is a console-based dealership application that allows salespeople or sales managers to manage vehicle inventory. The application follows object-oriented programming principles with a clean and intuitive user interface.

## Features

The application offers the following features:

1. Find vehicles within a price range
2. Find vehicles by make/model
3. Find vehicles by year range
4. Find vehicles by color
5. Find vehicles by mileage range
6. Find vehicles by type (car, truck, SUV, van)
7. List ALL vehicles
8. Add a vehicle
9. Remove a vehicle

## Project Structure

The project follows the Maven standard directory structure:

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── dealership/
│   │           ├── model/
│   │           │   ├── Vehicle.java
│   │           │   └── Dealership.java
│   │           ├── data/
│   │           │   └── DealershipFileManager.java
│   │           ├── ui/
│   │           │   └── UserInterface.java
│   │           └── Program.java
│   └── resources/
│       └── inventory.csv
```

## Class Descriptions

- **Vehicle**: Holds information about a specific vehicle (VIN, make, model, year, type, color, odometer, price)
- **Dealership**: Holds information about the dealership (name, address, phone) and maintains a list of vehicles with methods to search, add, and remove vehicles
- **DealershipFileManager**: Responsible for reading from and writing to the dealership file
- **UserInterface**: Handles user interaction, displaying menus, and processing user commands
- **Program**: Main class with the entry point for the application

## Data Storage Format

The application uses a pipe-delimited CSV file to store dealership and vehicle information. The file structure is:

- Line 1: Dealership information (name|address|phone)
- Line 2+: Vehicle information (vin|year|make|model|type|color|odometer|price)

Example:
```
D & B Used Cars|111 Old Benbrook Rd|817-555-5555
10112|1993|Ford|Explorer|SUV|Red|525123|995.00
37846|2001|Ford|Ranger|truck|Yellow|172544|1995.00
44901|2012|Honda|Civic|car|Gray|103221|6995.00
```

## How to Run the Project

### Prerequisites
- Java 11 or higher
- Maven

### Build and Run Instructions

1. Clone the repository
2. Navigate to the project directory
3. Build the project:
   ```
   mvn clean package
   ```
4. Run the application:
   ```
   java -jar target/car-dealership-1.0-SNAPSHOT.jar
   ```

Alternatively, you can run the application directly from your IDE by executing the `main` method in the `Program` class.

## Usage Instructions

1. When the application starts, you'll see a menu with numbered options
2. Enter the number corresponding to the action you want to perform
3. Follow the prompts to complete the action
4. After completing an action, press Enter to continue and return to the main menu
5. To exit the application, select option 99

## Best Practices Implemented

- Object-oriented design with appropriate class structure
- Proper error handling and input validation
- File I/O with proper resource management
- Clean code formatting and documentation
- Meaningful variable and method names
- Proper encapsulation with getters and setters
- Consistent user interface with clear instructions
