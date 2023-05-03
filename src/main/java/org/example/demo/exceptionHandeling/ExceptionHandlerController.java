package org.example.demo.exceptionHandeling;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestControllerAdvice
public class ExceptionHandlerController {
/**
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
*/
}

