package co.edu.udea.backend.utils.exceptions;

/**
 * Class to handle HTTP exceptions responses
 */
public class HTTPExceptionResponse {
    /**
     * The message of the error that occurred
     */
    private final String error;
    /**
     * The status code of the error that occurred
     */
    private final int status;

    /**
     * Full Constructor for the HTTPExceptionResponse class
     *
     * @param error  the message of the error that occurred
     * @param status the status code of the error that occurred
     */
    public HTTPExceptionResponse(String error, int status) {
        this.error = error;
        this.status = status;
    }

    // Getters
    public String getError() {
        return error;
    }

    public int getStatus() {
        return status;
    }
}
