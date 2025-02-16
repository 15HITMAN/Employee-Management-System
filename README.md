# Employee Management System

## Overview
The **Employee Management System (EMS)** is a Java-based application that allows users to manage employee records efficiently. The system supports CRUD operations (Create, Read, Update, Delete) for employees and includes user authentication via login and signup functionalities. It uses **JDBC** to interact with a MySQL database.

## Features
- **User Authentication**: Secure login and signup system.
- **Employee Management**:
  - Add new employees.
  - View details of a specific employee.
  - View all employees.
  - Update employee details.
  - Delete an employee record.
- **Database Integration**: Uses MySQL for persistent storage.
- **Interactive Console Interface**: User-friendly command-line interface for interaction.

## Technologies Used
- **Java (JDK 8+)**
- **JDBC (Java Database Connectivity)**
- **MySQL (Database Management System)**

## Prerequisites
Before running the project, ensure you have the following installed:
- **Java Development Kit (JDK)** (Version 8 or higher)
- **MySQL Database Server**
- **JDBC Driver** (MySQL Connector/J)

## Database Setup
1. **Create the Database:**
   ```sql
   CREATE DATABASE emp;
   ```
2. **Create the `signup` table:**
   ```sql
   CREATE TABLE signup (
       first_name VARCHAR(50),
       last_name VARCHAR(50),
       username VARCHAR(50) PRIMARY KEY,
       password VARCHAR(50)
   );
   ```
3. **Create the `employee` table:**
   ```sql
   CREATE TABLE employee (
       eid INT PRIMARY KEY,
       employee_name VARCHAR(100),
       employee_salary INT,
       employee_address VARCHAR(255),
       employee_email VARCHAR(100)
   );
   ```

## Installation & Running the Project
1. **Clone the Repository:**
   ```sh
   git clone https://github.com/your-repo/EmployeeManagementSystem.git
   cd EmployeeManagementSystem
   ```
2. **Compile the Java Files:**
   ```sh
   javac -cp .;mysql-connector-java-8.0.33.jar Employee.java
   ```
3. **Run the Application:**
   ```sh
   java -cp .;mysql-connector-java-8.0.33.jar Employee
   ```

## Usage
1. **Start the application.**
2. **Login** with an existing account or **Signup** to create a new account.
3. **Choose from the following options:**
   - Create a new employee.
   - View employee details.
   - View all employees.
   - Update an employee record.
   - Delete an employee record.

## Possible Enhancements
- Implement a GUI using JavaFX or Swing.
- Add password hashing for secure authentication.
- Implement role-based access control (Admin, HR, Employee).
- Create a REST API version of the system.

## Contribution
Feel free to fork this repository and submit pull requests for improvements.
