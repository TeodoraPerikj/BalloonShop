package mk.ukim.finki.lab.model.exceptions;

public class ManufacturerNotExistsException extends RuntimeException {
    public ManufacturerNotExistsException(Long id) {
        super(String.format("Manufacturer with id %i does not exists.",id));
    }
}
