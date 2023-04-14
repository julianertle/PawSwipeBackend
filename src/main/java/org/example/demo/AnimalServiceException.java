package org.example.demo;

import java.sql.SQLException;

public class AnimalServiceException extends RuntimeException {
    public AnimalServiceException(String message) {
        super(message);
    }
}