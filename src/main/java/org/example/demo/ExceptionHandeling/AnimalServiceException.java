package org.example.demo.ExceptionHandeling;

public class AnimalServiceException extends RuntimeException {
    public AnimalServiceException(String message) {
        super(message);
    }
}