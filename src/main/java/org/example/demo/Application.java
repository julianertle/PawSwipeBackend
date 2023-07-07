package org.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The Application class serves as the entry point for the Spring Boot application.
 * It is annotated with {@code @SpringBootApplication} to enable autoconfiguration,
 * component scanning, and other features provided by Spring Boot.
 *
 * @author Julian Ertle
 */
@SpringBootApplication
public class Application {

	/**
	 * The main method is the entry point of the application.
	 * It initializes and starts the Spring Boot application by invoking
	 * {@link SpringApplication#run(Class, String...)} with the {@code Application} class and command line arguments.
	 *
	 * @param args The command line arguments passed to the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
