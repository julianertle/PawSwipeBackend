package org.example.demo.exceptionHandeling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class AnimalServiceException extends RuntimeException {
    public AnimalServiceException(String message) {
        super(message);
    }

    @ExceptionHandler(AnimalServiceException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleAnimalServiceException(AnimalServiceException ex) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Animal Service Error",
                "An error occurred while processing your animal service request.",
                ex.getMessage()
        );
    }
}