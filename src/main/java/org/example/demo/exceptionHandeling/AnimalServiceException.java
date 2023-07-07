package org.example.demo.exceptionHandeling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The {@link AnimalServiceException} class is a custom exception that represents an error
 * specific to the animal service in the application. It extends the {@link RuntimeException}
 * class, making it an unchecked exception.
 * The class provides a constructor for creating an instance with a custom error message.
 * It also includes an exception handler to handle instances of this exception and generate
 * an appropriate error response.
 * This exception is typically thrown when an error occurs during the processing of animal service requests.
 *
 * @author Julian Ertle
 */
public class AnimalServiceException extends RuntimeException {
    public AnimalServiceException(String message) {
        super(message);
    }

    /**
     * Exception handler for handling instances of AnimalServiceException.
     * It maps the exception to an HTTP status code of 500 (Internal Server Error)
     * and generates an ErrorResponse object with the appropriate error details.
     *
     * @param ex The AnimalServiceException instance to handle.
     * @return An ErrorResponse object representing the error response.
     */
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