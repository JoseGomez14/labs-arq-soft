package co.edu.udea.backend.utils.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.format.DateTimeParseException;

/**
 * Controller advice to handle exceptions
 */
@RestControllerAdvice
public class ControllerAdvice {
    /**
     * Method to handle DateTimeParseException
     *
     * @param e the exception to handle
     * @return the response with the error message and status
     */
    @ExceptionHandler(DateTimeParseException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public HTTPExceptionResponse handleDateTimeParseException(DateTimeParseException e) {
        int status = HttpStatus.BAD_REQUEST.value();
        String error = "The date format is invalid";
        return new HTTPExceptionResponse(error, status);
    }

    /**
     * Method to handle IllegalArgumentException
     *
     * @param e the exception to handle
     * @return the response with the error message and status
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public HTTPExceptionResponse handleIllegalArgumentException(IllegalArgumentException e) {
        int status = HttpStatus.BAD_REQUEST.value();
        String error = "Given parameter is invalid: " + e.getMessage();
        return new HTTPExceptionResponse(error, status);
    }

    /**
     * Method to handle RuntimeException
     *
     * @param e the exception to handle
     * @return the response with the error message and status
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public HTTPExceptionResponse handleRuntimeException(RuntimeException e) {
        int status = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String error = "An internal server error occurred during request handling";
        return new HTTPExceptionResponse(error, status);
    }
}
