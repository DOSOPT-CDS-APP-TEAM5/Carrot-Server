package CarrotServer.exception.model;

import CarrotServer.exception.enums.Error;

public class CarrotException extends RuntimeException {
    private final Error error;
    public CarrotException(Error error,String message) {
        super(message);
        this.error = error;
    }

    public int getHttpStatus() {
        return error.getHttpStatus();
    }
}
