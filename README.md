
# Employee management system

This repository contains the source code and documentation for an Employee Management System.
The project is made on Java swing and Mysql database. IntelliJ IDEA was used as a code editor.

## Features

- Add update delete employee information
- Generate reports with print 
- Signup and login


## Installation

1. Clone this repository.
2. Install the necessary dependencies.
3. Run the application.

## Database setup
```bash
1) create mysql user and password ;
2)create database;
3 create table  Signup;
 -CREATE TABLE Signup (
    employe_id VARCHAR(20),
    username VARCHAR(20),
    user VARCHAR(20),
    password VARCHAR(20)
);
4 create table  employee;
 -CREATE TABLE employee (
    name VARCHAR(20),
    Fname VARCHAR(20),
    Dob VARCHAR(30),
    salary VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(20),
    email VARCHAR(20),
    designation VARCHAR(20),
    heducation VARCHAR(20),
    eid VARCHAR(20)
);
```
    
## Dependecies 
If there is any problem in  executing the code then.
import  the following packages and place it in project structure of IntelliJ IDEA.
-mysql-connector.jar,
-ResultSet2xml.jar,
-jcalendar-tz-1.3.3-4.jar,


## Screenshots

Start page

![Start](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-53-44.png)

Login page

![Login](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-54-47.png)

Signup page

![Signup](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-55-10.png)

Main Dashboard

![Main Dashboard](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Signup.png)

Add Employee

![Add](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-56-11.png)

View Employee
![Delete](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-56-33.png)

Delete
![Delete](https://github.com/bistakazi098/Employee_management_system/blob/master/Screenshort/Screenshot%20from%202023-08-17%2011-57-28.png)
