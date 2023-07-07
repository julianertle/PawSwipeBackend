package org.example.demo.exceptionHandeling;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

/**
 * The {@link ExceptionHandlerController} is a global exception handler for handling specific exceptions
 * in the RESTful API controllers. It provides methods annotated with @ExceptionHandler to handle different types of exceptions.
 * The class is annotated with @RestControllerAdvice to indicate that it provides advice for RESTful controllers.
 * It handles SQLException and JsonProcessingException and returns appropriate error responses.
 * Each exception handling method returns an ErrorResponse object representing the error response.
 * The methods are annotated with @ResponseStatus and @ResponseBody to set the HTTP response status and return the response body.
 * This class ensures that specific exceptions are caught, and custom error responses are returned to the client.
 *
 * @author Julian Ertle
 */
@RestControllerAdvice
public class ExceptionHandlerController {

    /**
     * Handles SQLException and returns an error response with an appropriate HTTP status code.
     *
     * @param ex The SQLException that occurred.
     * @return An ErrorResponse object representing the error response.
     */
    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleSQLException(SQLException ex) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Database Error",
                "An error occurred while processing your request.",
                ex.getMessage()
        );
    }

    /**
     * Handles JsonProcessingException and returns an error response with an appropriate HTTP status code.
     *
     * @param ex The JsonProcessingException that occurred.
     * @return An ErrorResponse object representing the error response.
     */
    @ExceptionHandler(JsonProcessingException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleJsonProcessingException(JsonProcessingException ex) {
        return new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Animal Service Error",
                "Error processing JSON request: ",
                ex.getMessage()
        );
    }
}

