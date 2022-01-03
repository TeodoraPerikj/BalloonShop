package mk.ukim.finki.lab.model.exceptions;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super(String.format("Order with id %d not found.",id));
    }
}
