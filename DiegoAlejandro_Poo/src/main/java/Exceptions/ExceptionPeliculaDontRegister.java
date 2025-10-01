package Exceptions;

public class ExceptionPeliculaDontRegister extends RuntimeException {
    public ExceptionPeliculaDontRegister(String message) {
        super(message);
    }
}
