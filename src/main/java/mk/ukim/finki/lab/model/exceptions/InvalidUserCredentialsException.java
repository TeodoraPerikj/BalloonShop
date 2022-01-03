package mk.ukim.finki.lab.model.exceptions;

public class InvalidUserCredentialsException extends RuntimeException {

    public InvalidUserCredentialsException() {
        super("Invalid User Credentials!");
    }
}
