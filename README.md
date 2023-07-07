
# PawSwipe Backend

This project is the development of a database and its RESTful service for an app that facilitates human-animal mediation. It is being developed as part of the "Software Lab" event at Heilbronn University.

The goal of the project is to create a platform that connects individuals looking to adopt or foster animals with animal shelters or rescue organizations. The app will allow users to browse available animals, view their profiles, and express interest in adopting or fostering them.

## Installation

This project has been tested on a Debian 11 remote server that works with a MariaDB database (mysql Ver 15.1 Distrib 10.9.5-MariaDB, for debian-linux-gnu (x86_64)).

To set up the development environment, please follow these steps:

### 1. Set up the Linux MariaDB Server

Follow this tutorial to install and start using MariaDB on Ubuntu 20.04: [How to Install and Start Using MariaDB on Ubuntu 20.04](https://www.cherryservers.com/blog/how-to-install-and-start-using-mariadb-on-ubuntu-20-04)

### 2. Install Spring Boot

Make sure you have Spring Boot installed. We recommend using Spring version 105.0.1. If you need help installing Spring Boot, refer to the official documentation: [Getting Started with Spring Boot](https://docs.spring.io/spring-boot/docs/1.2.0.M2/reference/html/getting-started-installing-spring-boot.html)

### 3. Configure the Application

Clone the repository: git clone https://github.com/julianertle/PawSwipeBackend.git

### 4. Database Setup

Run the following DDL script to set up the required tables in the database:

```bash

 CREATE TABLE `animal` (
	`animal_id` INT(10) NOT NULL AUTO_INCREMENT,
	`profile_id` INT(10) NOT NULL,
	`species` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`name` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`birthday` DATE NULL DEFAULT NULL,
	`illness` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`description` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`breed` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`color` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`gender` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`picture_one` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`picture_two` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`picture_three` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`picture_four` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`picture_five` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	PRIMARY KEY (`animal_id`) USING BTREE,
	INDEX `FKanimal153142` (`profile_id`) USING BTREE,
	CONSTRAINT `FKanimal153142` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`) ON UPDATE RESTRICT ON DELETE CASCADE
) COLLATE='utf8mb4_general_ci' ENGINE=InnoDB AUTO_INCREMENT=14;

CREATE TABLE `liked_animals` (
	`profile_id` INT(10) NOT NULL,
	`animal_id` INT(10) NOT NULL,
	PRIMARY KEY (`profile_id`, `animal_id`) USING BTREE,
	INDEX `FKliked_anim356657` (`animal_id`) USING BTREE,
	CONSTRAINT `FKliked_anim356657` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`animal_id`) ON UPDATE RESTRICT ON DELETE CASCADE,
	CONSTRAINT `FKliked_anim506270` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`profile_id`) ON UPDATE RESTRICT ON DELETE CASCADE
) COLLATE='utf8mb4_general_ci' ENGINE=InnoDB;

CREATE TABLE `profile` (
	`profile_id` INT(10) NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(16) NOT NULL COLLATE 'utf8mb4_general_ci',
	`profile_picture` MEDIUMTEXT NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`description` VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`password` VARCHAR(64) NOT NULL COLLATE 'utf8mb4_general_ci',
	`creation_date` DATE NULL DEFAULT NULL,
	`email` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`birthday` DATE NULL DEFAULT NULL,
	`phone_number` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`opening_hours` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`street` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`country` VARCHAR(35) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`city` VARCHAR(35) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`street_number` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`homepage` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`postal_code` VARCHAR(25) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`discriminator` VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	`firstname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`lastname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	`is_admin` TINYINT(4) NULL DEFAULT NULL,
	`lat` DOUBLE NULL DEFAULT NULL,
	`lon` DOUBLE NULL DEFAULT NULL,
	PRIMARY KEY (`profile_id`) USING BTREE,
	UNIQUE INDEX `username` (`username`) USING BTREE,
	UNIQUE INDEX `email` (`email`) USING BTREE,
	UNIQUE INDEX `phone_number` (`phone_number`) USING BTREE
) COLLATE='utf8mb4_general_ci' ENGINE=InnoDB AUTO_INCREMENT=12;
```

### 5. Configure the API Base URL

If you work with your own local or own remote server, you need to change the BASE_URL variable in multiple API classes in the [Android Studio Pawswipe project](https://github.com/FelixAlexK/PawSwipe.git). This will allow your device, on which the application "PawSwipe" is running, to connect to the RESTful API backend server.

### 6. Build and Run the Project

Build and run the project using your preferred Java IDE or the command line.
Getting Started

Once the project is set up and the backend service is running, you can access the API endpoints to interact with the app's functionality. Refer to the API documentation for more details on the available endpoints and their usage.

Feel free to customize this template to fit your project's specific details and requirements.


## Authors

- [@julianertle](https://github.com/julianertle)

