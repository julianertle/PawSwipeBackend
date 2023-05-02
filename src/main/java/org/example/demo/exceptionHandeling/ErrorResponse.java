package org.example.demo.exceptionHandeling;

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

