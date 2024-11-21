# Gym Management System Application

This project is a **Gym Management System** application built using **Java** and the **Spring Framework**. It provides a console-based interface for managing gym members, trainers, payments, and memberships. The application demonstrates the use of Spring’s core features like dependency injection and configuration via `AnnotationConfigApplicationContext`.

## Features

- **Member Management**: Add, update, delete, and retrieve member details.
- **Trainer Management**: Add, update, delete, and retrieve trainer details.
- **Payment Management**: Process payments and manage payment records.
- **Membership Management**: Manage memberships, including adding, updating, retrieving, and deleting records.
- Console-based menu for easy interaction with the application.

## Technology Stack

- **Java**: Core programming language.
- **Spring Framework**: For dependency injection and bean management.
- **AnnotationConfigApplicationContext**: Used for configuring Spring beans via Java-based configuration.

## Prerequisites

- **Java JDK** (version 8 or above).
- **Maven** (for managing dependencies).
- **IDE**: Any Java IDE like IntelliJ IDEA, Eclipse, or VS Code.
- **Spring Framework**: Ensure Spring Core libraries are available in the project.

Application Menu
The console interface provides the following options:

## Member Management
Add Member
Get Member by ID
Get All Members
Update Member
Delete Member

## Trainer Management
Add Trainer
Get Trainer by ID
Get All Trainers
Update Trainer
Delete Trainer

## Payment Management
Process Payment
Get Payment by ID
Get All Payments
Update Payment
Delete Payment

## Membership Management
Add Membership
Get Membership by ID
Get All Memberships
Update Membership
Delete Membership
Exit
Exit the application.

## Project Structure
com.main: Contains the main application entry point.
com.config: Contains Spring configuration classes.
com.controller: Contains the Admin class that handles business logic for members, trainers, payments, and memberships.

## Future Enhancements
Add a database layer for persistent data storage.
Include validation for user inputs.
Develop a front-end interface (e.g., a web or desktop GUI).
Add role-based authentication for Admin and Users.

## Contributing
Contributions are welcome! Fork the repository and submit a pull request for any feature or improvement.
