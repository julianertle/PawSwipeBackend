package org.example.demo.exceptionHandeling;

public class AnimalServiceException extends RuntimeException {
    public AnimalServiceException(String message) {
        super(message);
    }
}