package mk.ukim.finki.lab.model.exceptions;

public class InvalidUsernameOrPasswordException extends RuntimeException {
    public InvalidUsernameOrPasswordException(){
        super("Invalid username or password!");
    }
}
