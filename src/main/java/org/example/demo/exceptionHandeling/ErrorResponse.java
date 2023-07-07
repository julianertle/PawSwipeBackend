package org.example.demo.exceptionHandeling;

/**
 * The {@link ErrorResponse} class represents an error response in the RESTful API.
 * It encapsulates the status, error, message, and exception message of the error response.
 * The class provides getters and setters for accessing and modifying the error response attributes.
 * It is used by the exception handling mechanism to generate consistent error responses.
 *
 * @author Julian Ertle
 */
public class ErrorResponse  {
    private int status;
    private String error;
    private String message;
    private String exceptionMessage;

    public ErrorResponse(int status, String error, String message, String exceptionMessage) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.exceptionMessage = exceptionMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }
}

